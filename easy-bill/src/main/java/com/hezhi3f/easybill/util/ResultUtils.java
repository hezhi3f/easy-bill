package com.hezhi3f.easybill.util;

import com.hezhi3f.easybill.exception.ExceptionType;
import com.hezhi3f.easybill.result.Result;

public class ResultUtils {
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setOk(true);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> success(String msg, T t) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setOk(true);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setOk(true);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> error(ExceptionType exceptionType) {
        Result<T> result = new Result<>();
        result.setCode(exceptionType.getCode());
        result.setMsg(exceptionType.getMsg());
        result.setData(null);
        return result;
    }
}
