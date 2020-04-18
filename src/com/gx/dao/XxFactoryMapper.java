package com.gx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gx.po.XxFactory;
import com.gx.po.XxFactoryExample;

public interface XxFactoryMapper {
    int countByExample(XxFactoryExample example);

    int deleteByExample(XxFactoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XxFactory record);

    int insertSelective(XxFactory record);

    List<XxFactory> selectByExample(XxFactoryExample example);

    XxFactory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XxFactory record, @Param("example") XxFactoryExample example);

    int updateByExample(@Param("record") XxFactory record, @Param("example") XxFactoryExample example);

    int updateByPrimaryKeySelective(XxFactory record);

    int updateByPrimaryKey(XxFactory record);
    
    //自定义方法
	public void deleteAll(int[] ids);	//批量删除；支持整数型和字符串类型ID
	public void updateState(Map<String,Object> map);	//修改状态
}