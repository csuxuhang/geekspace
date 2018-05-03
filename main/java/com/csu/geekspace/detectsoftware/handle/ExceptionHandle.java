package com.csu.geekspace.detectsoftware.handle;

import com.csu.geekspace.detectsoftware.Exception.MyException;
import com.csu.geekspace.detectsoftware.aspect.HttpAspect;
import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.pojo.Outcome;
import com.csu.geekspace.detectsoftware.pojo.Result;
import com.csu.geekspace.detectsoftware.utils.OutcomeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获(区分系统异常与自己定义的异常，方便管理)
 * @Author xuhang
 * @date 2018/4/12 14:42
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @ExceptionHandler(value = java.lang.Exception.class)
    @ResponseBody
    public Outcome handle(java.lang.Exception e){
        if (e instanceof MyException){
            MyException myException = (MyException) e;
            return OutcomeUtil.error(myException.getCode(), myException.getMessage());
        }else {
            logger.info("【系统异常】={}",e);
            return OutcomeUtil.error(OutcomeEnum.UNKNOW_ERROR);
        }
    }
}
