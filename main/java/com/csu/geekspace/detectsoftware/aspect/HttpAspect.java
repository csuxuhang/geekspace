package com.csu.geekspace.detectsoftware.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xuhang
 * @date 2018/4/11 22:43
 */
@Aspect
@Component
public class HttpAspect {
    //处理逻辑代码
    //日志记录
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //配置切点
    @Pointcut("execution(public * com.csu.geekspace.detectsoftware.controller.*.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //IP
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @AfterReturning(returning ="object",pointcut = "log()")
    public void doAfterReturning(Object object){
        //获取返回值
        logger.info("response={}",object.toString());
    }
}
