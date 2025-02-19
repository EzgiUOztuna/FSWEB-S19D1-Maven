package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<PlantErrorResponse> handleException(PlantException exception){

        log.error("PlantException occured",exception);

        PlantErrorResponse errorResponse = new PlantErrorResponse(exception.getHttpStatus().value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){

        log.error("PlantException occured",exception);

        PlantErrorResponse errorResponse = new PlantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}