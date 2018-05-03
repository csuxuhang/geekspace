package com.csu.geekspace.detectsoftware.utils;

import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.pojo.Outcome;

/**
 * @Author xuhang
 * @date 2018/4/12 10:06
 */
public class OutcomeUtil {

    public static Outcome success(OutcomeEnum anEnum){
        Outcome outcome = new Outcome();
        outcome.setCode(anEnum.getCode());
        outcome.setMsg(anEnum.getMsg());
        return outcome;
    }
    public static Outcome success(){
        return success(null);
    }
    public static Outcome error(Integer code,String msg){
        Outcome outcome = new Outcome();
        outcome.setCode(code);
        outcome.setMsg(msg);
        return outcome;
    }
    public static Outcome error(OutcomeEnum anEnum){
        Outcome outcome = new Outcome();
        outcome.setCode(anEnum.getCode());
        outcome.setMsg(anEnum.getMsg());
        return outcome;
    }
}
