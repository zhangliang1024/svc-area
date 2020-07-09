package com.ncme.svc.area.exception;

import com.ncme.svc.area.response.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @Author: colin
 * @Date: 2019/3/25 09:51
 * @Description:
 * @Version: V1.0
 */
@ControllerAdvice
@Slf4j
public class AreasExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleResponse exceptionHandler(Exception e){
        log.warn("服务端异常：{}" ,e.getMessage());
        return new SimpleResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleResponse numberFormatExceptionHandler(MethodArgumentTypeMismatchException e){
        log.warn("类型转换异常：{}" ,e.getMessage());
        return new SimpleResponse("请求参数异常");
    }

}
