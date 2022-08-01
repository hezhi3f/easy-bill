package com.hezhi3f.easybill.exception;

public class BillException extends RuntimeException{
    private final ExceptionType exceptionType;

    public BillException(ExceptionType exceptionType) {
        super(exceptionType.getMsg());
        this.exceptionType = exceptionType;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}
