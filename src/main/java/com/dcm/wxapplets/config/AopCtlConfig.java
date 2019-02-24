package com.dcm.wxapplets.config;

import com.dcm.wxapplets.exception.DataExistedException;
import com.dcm.wxapplets.exception.FalseActionException;
import com.dcm.wxapplets.exception.FormValidException;
import com.dcm.wxapplets.exception.SessionInvalidException;
import com.dcm.wxapplets.utils.date.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName: AopCtlConfig
 * @Description: 针对Controller返回值组装和异常处理的Aop配置
 * @Auther: dcm
 * @Date: 2018-6-1 14:53
 */

@Aspect
@Component
public class AopCtlConfig {

    private static final Logger log = LoggerFactory.getLogger(AopCtlConfig.class);

    /**
     前置通知（Before）：在目标方法被调用之前调用通知功能。
     后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么。
     返回通知（After-returning）：在目标方法成功执行之后调用通知。
     异常通知（After-throwing）：在目标方法抛出异常后调用通知。
     环绕通知（Around，前+后）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。
     */

    // 范围：返回值为*的com.dcm.wxapplets.controller包下的以Ctl结尾的类的所有方法  并且  加了@CtlResultAnnotation注解的
    @Around("execution(* com.dcm.wxapplets.controller..*Ctl.*(..)) && @annotation(com.dcm.wxapplets.config.CtlResultAnnotation)")
    @Order(12)
    public Object handleCtlResult(ProceedingJoinPoint joinPoint) {

        ResultVO<Object> result = new ResultVO();
        try {
            // 无论如何，凡是@Around的都必须执行proceed方法，否则切入点的方法体将无法执行; 但是只要执行了此方法，切入点的方法则一定会执行
            result = (ResultVO<Object>) joinPoint.proceed(joinPoint.getArgs());
            if( result.getStatus() == 0) {
                result.setStatus(ResultCode.CODE_200);
                result.setMessage(ResultCode.CODE_SUCCESS);
                result.setServerTime(DateUtil.getCurrTimeStr());
            }
        } catch (Throwable e) {
            result = handleCtlResultException(joinPoint, e, result);
        }
        return result;
    }

    private ResultVO<Object> handleCtlResultException(ProceedingJoinPoint jp, Throwable e, ResultVO result) {

        result.setMessage(e.toString());
        result.setStatus(ResultCode.CODE_500);
        result.setServerTime(DateUtil.getCurrTimeStr());
        if (e instanceof FormValidException) {
            result.setStatus(ResultCode.CODE_400);
            log.error("【FormValidException】--方法是：【" + jp.getSignature() + "】异常原因是：【" + e.getMessage() + "】");
        } else if (e instanceof SessionInvalidException) {
            result.setStatus(ResultCode.CODE_401);
            log.error("【SessionInvalidException】--方法是：【" + jp.getSignature() + "】异常原因是：【" + e.getMessage() + "】");
        } else if (e instanceof DataExistedException) {
            result.setStatus(ResultCode.CODE_403);
            log.error("【DataExistedException】--方法是：【" + jp.getSignature() + "】异常原因是：【" + e.getMessage() + "】");
        } else if (e instanceof FalseActionException) {
            result.setStatus(ResultCode.CODE_501);
            log.error("【FalseActionException】--方法是：【" + jp.getSignature() + "】异常原因是：【" + e.getMessage() + "】");
        } else if (e instanceof RuntimeException) {
            log.error("【RuntimeException】--方法是：【" + jp.getSignature() + "】参数是：【" + Arrays.asList(jp.getArgs()).toString() + "】异常原因是：【" + e.getMessage() + "】打印异常堆栈如下：", e);
        } else {
            log.error("【其它异常】--方法是：【" + jp.getSignature() + "】参数是：【" + Arrays.asList(jp.getArgs()).toString() + "】异常原因是：【" + e.getMessage() + "】打印异常堆栈如下：", e);
        }
        result.setMessage(e.getMessage());
        return result;
    }

}
