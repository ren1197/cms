package com.gx.aop;

import com.alibaba.fastjson.JSON;
import com.gx.annotation.Log;
import com.gx.po.OperationLog;
import com.gx.po.UserPo;
import com.gx.service.OperationLogService;
import com.gx.utils.ServerUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class LogAop {
    @Autowired
    OperationLogService logService;

    @Pointcut("execution(* com.gx.web.article..*.insert*(..))")
    public void controllerInsertAspect() {

    }

    @Pointcut("execution(* com.gx.web.article..*.update(..))")
    public void controllerUpdateAspect() {

    }

    @Pointcut("execution(* com.gx.web.article..*.*del*(..))")
    public void controllerDelAspect() {

    }

    @Pointcut("execution(* com.gx.web.article..*.*Del*(..))")
    public void controllerLogicDelAspect() {

    }

    @Pointcut(value = " controllerDelAspect()|| controllerInsertAspect()||controllerUpdateAspect()||controllerLogicDelAspect()")
    public void controllerAspect() {

    }

    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {
        UserPo login = (UserPo) ServerUtils.getSession().getAttribute("login");
//        String params = JSON.toJSONString(ServerUtils.getRequest().getParameterMap());
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof MultipartFile)
                args[i] = "文件";
        }
        String params = JSON.toJSONString(args);
        System.out.println("参数:" + JSON.toJSONString(joinPoint.getArgs()));

        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operation = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operation = method.getAnnotation(Log.class).operation();
                        break;
                    }
                }
            }

            if (login != null) {
                logService.createLog(login, params, operation, operationType);
            } else {
                logService.createLog(null, params, operation, operationType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
