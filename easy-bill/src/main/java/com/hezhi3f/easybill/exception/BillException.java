package com.hezhi3f.easybill.exception;

import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.result.builder.ResultBuilder;

public class BillException extends RuntimeException {
    private Integer code = -1;
    private String msg = "";

    public BillException(ExceptionType exceptionType) {
        super(exceptionType.getMsg());
        code = exceptionType.getCode();
        msg = exceptionType.getMsg();
    }

    public BillException(String msg) {
        super(msg);
    }

    public Result<Void> getResult() {
        return ResultBuilder.<Void>empty()
                .withCode(code)
                .withMsg(msg)
                .withOk(false)
                .build();
    }

}
