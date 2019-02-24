package com.dcm.wxapplets.config;

/**
 * @ClassName: ResultCode
 * @Description: 返回结果状态码和提示信息
 * @Auther: dcm
 * @Date: 2018-6-1 16:30
 */

public class ResultCode {

    /**正常*/
    public static int CODE_200 = 200;

    /**表单校验不通过*/
    public static int CODE_400 = 400;

    /**鉴权不通过*/
    public static int CODE_401 = 401;

    /**服务器收到，但是不予处理*/
    public static int CODE_403 = 403;

    /**信息缺失*/
    public static int CODE_405 = 405;

    /**服务器异常*/
    public static int CODE_500 = 500;

    /**成功的提示信息*/
    public static String CODE_SUCCESS = "success";

    /**错误的操作行为*/
    public static int CODE_501 = 501;


}
