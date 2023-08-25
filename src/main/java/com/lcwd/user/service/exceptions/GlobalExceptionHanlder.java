package com.lcwd.user.service.exceptions;

import com.lcwd.user.service.exceptions.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHanlder {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourcentFoundException(ResourceNotFoundException ex){
        String message =  ex.getMessage();
       ApiResponse response =  ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
   return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
