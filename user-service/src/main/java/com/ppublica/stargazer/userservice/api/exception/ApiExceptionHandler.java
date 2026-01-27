package com.ppublica.stargazer.userservice.api.exception;

import com.ppublica.stargazer.userservice.application.exception.UserAlreadyExistsException;
import com.ppublica.stargazer.userservice.application.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(UserNotFoundException ex, HttpServletRequest request) {
        return ErrorResponse.of("USER_NOT_FOUND", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handle(UserAlreadyExistsException ex, HttpServletRequest request) {
        return ErrorResponse.of("USER_ALREADY_EXISTS", ex.getMessage(), request.getRequestURI());
    }


}
