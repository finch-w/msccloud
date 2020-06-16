package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private static final Integer success = 200;
    private static final Integer fail404 = 404;

    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public static class CommonResultUtil {
        public final static Integer OK_CODE = 200;
        public final static String OK_MESSAGE = "操作成功";
        public final static Integer SYSTEM_ERROR = 500;
        public final static String SYSTEM_ERROR_MESSAGE = "系统错误";

    }
}
