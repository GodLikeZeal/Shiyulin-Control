package com.zeal.shiyulin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Zeal on 2016/10/24.
 */
@ControllerAdvice
public class ZealExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(ZealException.class)
    @ResponseBody
    public ZealExceptionErrorInfo handleIllegal(ZealException e) {
        return new ZealExceptionErrorInfo("请求异常", e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ZealExceptionErrorInfo handleIllegal1(ZealException e) {
        return new ZealExceptionErrorInfo("服务器内部异常", e);
    }

}
