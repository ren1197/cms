package com.gx.Test;

import java.util.Date;

import com.gx.utils.DateUtil;

public class TestDate {
public static void main(String[] args) {
	String cron=DateUtil.getCron(new Date());  
    System.out.println(cron);  
}
}
