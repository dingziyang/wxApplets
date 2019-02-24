package com.dcm.wxapplets.utils;

import java.util.UUID;

/**
 * Created by jmx on 2018-9-14
 * 给主键类型是varchar(32)的生成uuid
 */
public class UUIDUtil {

    /**
     * 获取生成的uuid
     * "-" 替换为 ""
     * 字母转换为大写
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
