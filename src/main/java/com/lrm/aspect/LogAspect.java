package com.lrm.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author wu
 * @date 2022-01-16 19:37
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.lrm.web.*.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
        //获取返回的参数
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
         logger.info("Request:"+requestLog);

    }
    @After("log()")
    public void doAfter(){
//        logger.info("------doAfter---------");
    }
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result :"+result);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @ToString
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
