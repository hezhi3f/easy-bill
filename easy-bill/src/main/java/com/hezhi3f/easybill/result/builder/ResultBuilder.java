package com.hezhi3f.easybill.result.builder;

import com.hezhi3f.easybill.exception.ExceptionType;
import com.hezhi3f.easybill.result.Result;

public class ResultBuilder<T> {
    private Integer code;
    private Boolean ok;
    private String msg;
    private T data;

    private ResultBuilder() {
    }

    public static <T> ResultBuilder<T> empty() {
        return new ResultBuilder<>();
    }

    public static <T> ResultBuilder<T> success() {
        ResultBuilder<T> builder = new ResultBuilder<>();
        builder.code = 200;
        builder.ok = true;
        builder.msg = "success";

        return builder;
    }

    public static <T> ResultBuilder<T> success(T data) {
        ResultBuilder<T> builder = new ResultBuilder<>();
        builder.code = 200;
        builder.ok = true;
        builder.msg = "success";
        builder.data = data;
        return builder;
    }


    public static <T> ResultBuilder<T> error(ExceptionType exceptionType) {
        ResultBuilder<T> builder = new ResultBuilder<>();
        builder.code = exceptionType.getCode();
        builder.ok = false;
        builder.msg = exceptionType.getMsg();
        return builder;
    }

    public ResultBuilder<T> withCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResultBuilder<T> withOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public ResultBuilder<T> withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultBuilder<T> withData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> build() {
        Result<T> r = new Result<>();
        r.setCode(this.code);
        r.setOk(this.ok);
        r.setMsg(this.msg);
        r.setData(this.data);
        return r;
    }
}
