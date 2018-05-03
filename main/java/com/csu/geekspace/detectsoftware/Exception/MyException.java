package com.csu.geekspace.detectsoftware.Exception;

import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;

/**
 * 只有抛出RuntimeException才会进行事务回滚
 * @Author xuhang
 * @date 2018/4/12 14:48
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(OutcomeEnum outcomeEnum){
        super(outcomeEnum.getMsg());
        this.code = outcomeEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
