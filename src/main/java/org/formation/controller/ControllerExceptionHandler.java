package org.formation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handdleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {

        var p =  ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_CONTENT,
                "Validation Error"
        );

       var errors =  methodArgumentNotValidException.getBindingResult().getFieldErrors()
                .stream(    )
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage));

        return p;
    }

}
