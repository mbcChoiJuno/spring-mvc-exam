package org.spring.exam.exception;

import org.spring.exam.core.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
    @ExceptionHandler(Exception.class)
    public ApiError handleAllExceptions(Exception e) {
    	var status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    	var message = e.getMessage();
    	
        return new ApiError(status, message);
    }
}
