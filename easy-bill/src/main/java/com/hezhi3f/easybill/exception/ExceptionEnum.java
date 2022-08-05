package com.hezhi3f.easybill.exception;

public enum ExceptionEnum {
    SHOULD_NOT_OCCUR_ERROR(-1, "不应该出现的错误"),
    USERNAME_OR_PASSWORD_ERROR(1001, "用户名或者密码错误"),
    TOKEN_NOT_EXIST(1004, "token不存在"),
    TOKEN_VERIFY_ERROR(1002, "token验证失效"),
    USER_NOT_EXIST(1003, "用户不存在"),
    TOKEN_INFO_INCOMPLETE(1005, "token信息不完整"),
    REQUEST_PARAM_INCOMPLETE(1006, "请求参数不全"),
    USERNAME_ALREADY_EXISTS(1007, "用户名已被注册"),
    EMAIL_ALREADY_EXISTS(1008, "邮箱已被注册"),
    CHECK_CODE_INCORRECT(1009, "验证码不正确"),
    DATABASES_EXCEPTION(1010, "数据库出错");


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
