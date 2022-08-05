package com.hezhi3f.easybill.exception;

public class BillException extends RuntimeException {
    private final ExceptionEnum exceptionEnum;

    public BillException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
