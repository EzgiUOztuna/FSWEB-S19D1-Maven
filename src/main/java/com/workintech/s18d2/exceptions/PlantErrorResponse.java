package com.workintech.s18d2.exceptions;
import java.time.LocalDateTime;

public record PlantErrorResponse(Integer status, String message, LocalDateTime localDateTime) {
}