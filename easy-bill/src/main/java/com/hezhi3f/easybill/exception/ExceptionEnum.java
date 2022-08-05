package com.hezhi3f.easybill.exception;

public enum ExceptionEnum {
    SHOULD_NOT_OCCUR_ERROR(-1, "不应该出现的错误"),
    USERNAME_OR_PASSWORD_ERROR(1001, "用户名或者密码错误"),
    TOKEN_NOT_EXIST(1004, "token不存在"),
    TOKEN_VERIFY_ERROR(1002, "token验证失效"),
    USER_NOT_EXIST(1003, "用户不存在"),
    TOKEN_INFO_INCOMPLETE(1005, "token信息不完整");


    private final Integer code;
    private final String msg;

    ExceptionEnum(Integer code, String msg) {
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
