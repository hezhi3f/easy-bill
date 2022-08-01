package com.hezhi3f.easybill.exception;


public enum ExceptionType {
    USERNAME_OR_PASSWORD_ERROR(1000, "用户名或者密码错误");

    ;
    private Integer code;
    private String msg;

    ExceptionType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
