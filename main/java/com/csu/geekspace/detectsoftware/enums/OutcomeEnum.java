package com.csu.geekspace.detectsoftware.enums;

/**
 * @Author xuhang
 * @date 2018/4/12 15:04
 */
public enum OutcomeEnum {
    UNKNOW_ERROR(-10,"未知错误"),
    SUCCESS(0,"成功"),
    FILE_IS_NOT_EXCEL(-1,"文件不是Excel"),
    DATA_IS_NULL(-2,"数据为空，请填写数据"),
    IMPORT_ERROR(-3,"导入出错！请检查数据格式！"),
    I_IS_ZERO(-4,"电流为空"),
    INSERT_DEFEATED(-5,"插入失败")
    ;

    private Integer code;

    private String msg;

    OutcomeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
