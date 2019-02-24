package com.dcm.wxapplets.config;

import java.lang.annotation.*;

/**
 * @ClassName: CtlResultAnnotation
 * @Description: 控制器返回数据的自定义注解
 * @Auther: dcm
 * @Date: 2018-6-1 15:21
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CtlResultAnnotation {

}
