package com.hezhi3f.easybill.util;

import com.hezhi3f.easybill.exception.ExceptionEnum;
import com.hezhi3f.easybill.result.Result;

public class ResultUtils {

    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(200);
        result.setOk(true);
        result.setMsg("success");
        return result;
    }


    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setOk(true);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result<Void> error(ExceptionEnum exceptionEnum) {
        Result<Void> result = new Result<>();
        result.setCode(exceptionEnum.getCode());
        result.setOk(false);
        result.setMsg(exceptionEnum.getMsg());
        return result;
    }
}

