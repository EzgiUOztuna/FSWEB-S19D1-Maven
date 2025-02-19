package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<PlantErrorResponse> handleException(PlantException plantException)
    {
        PlantErrorResponse errorResponse = new PlantErrorResponse(plantException.getHttpStatus().value(),
                plantException.getMessage(), System.currentTimeMillis());
        log.error("Error occured",errorResponse);
        return new ResponseEntity<PlantErrorResponse>(errorResponse, plantException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception)
    {
        PlantErrorResponse errorResponse = new PlantErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<PlantErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}