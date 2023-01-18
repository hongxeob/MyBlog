package com.project.myblog.handler;

import com.project.myblog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //컨트롤러 전역에서 발생하는 예외를 잡아준다
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    private ResponseDto<String> handleArgumentException(Exception e) {
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}