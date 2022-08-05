package com.hezhi3f.easybill.aspect;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionEnum;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptionConfig {
    private static final Logger logger = LoggerFactory.getLogger(HandlerExceptionConfig.class);

    @ExceptionHandler(SignatureVerificationException.class)
    public Result<Void> tokenException(SignatureVerificationException e) {
        ExceptionEnum tokenVerifyError = ExceptionEnum.TOKEN_VERIFY_ERROR;

        logger.error(tokenVerifyError.getMsg(), e);
        return ResultUtils.error(tokenVerifyError);
    }

    @ExceptionHandler(BillException.class)
    public Result<Void> billException(BillException e) {
        logger.error(e.getMessage(), e);
        return ResultUtils.error(e.getExceptionEnum());
    }

}
