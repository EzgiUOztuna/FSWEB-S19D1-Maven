package com.workintech.s18d2.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlantException extends RuntimeException{
    private HttpStatus httpStatus;

    public PlantException(String message, HttpStatus httpStatus)
    {
        super(message);
        this.httpStatus = httpStatus;
    }
}