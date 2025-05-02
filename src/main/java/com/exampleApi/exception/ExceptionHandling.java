package com.exampleApi.exception;

import com.exampleApi.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice //Makes this class as a global exception handler(centralized error handler) in this SB project.
public class ExceptionHandling {

    @ExceptionHandler(ResourceNotFound.class) //Specifies which exception to handle.
    public ResponseEntity<ErrorDto> resourceNotFoundException(
            ResourceNotFound r,
            WebRequest req
    ) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(new Date());
        errorDto.setMessage(r.getMessage());
        errorDto.setRequest(req.getDescription(true));
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class) //Specifies which exception to handle.
    public ResponseEntity<ErrorDto> anyTypeOfException(
            Exception e,
            WebRequest req
    ) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(new Date());
        errorDto.setMessage(e.getMessage());
        errorDto.setRequest(req.getDescription(false));
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
