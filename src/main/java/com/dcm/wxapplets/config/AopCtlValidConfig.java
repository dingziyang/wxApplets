package com.dcm.wxapplets.config;

import com.dcm.wxapplets.exception.FormValidException;
import com.dcm.wxapplets.utils.date.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * @ClassName: AopCtlValidConfig
 * @Description: 针对Controller入参校验的Aop配置
 * @Auther: dcm
 * @Date: 2018-6-11 17:29
 */

@Aspect
@Component
public class AopCtlValidConfig {

    private static final Logger log = LoggerFactory.getLogger(AopCtlValidConfig.class);

    @Before("execution(* com.dcm.wxapplets.controller..*Ctl.*(..)) && @annotation(com.dcm.wxapplets.config.CtlValidAnnotation)")
    @Order(11) // 序号越小的优先级越高，先执行
    public Object handleCtlValid(JoinPoint joinPoint) {

        ResultVO<Object> result = new ResultVO();
        BindingResult validResult ;
        Object form = new Object();

        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                validResult = (BindingResult) arg;
                if (validResult.hasErrors()){
                    result.setStatus(ResultCode.CODE_400);
                    result.setMessage("Bad Request : " + validResult.getFieldError().getDefaultMessage());
                    result.setServerTime(DateUtil.getCurrTimeStr());
                    throw new FormValidException("表单校验不通过!原因是：["+ validResult.getFieldError().getDefaultMessage() +"]；表单参数是：" + form.toString());
                }
            }
            if (arg.getClass().getName().contains("com.dcm.wxapplets.entity")) {
                form = arg;
            }
        }

        return result;
    }

}
