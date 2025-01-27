package org.example.crudrs.dtos;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        int status,
        String timestamp,
        String endpoint
) {
    public ErrorResponseDto(String message, int status, String path) {
        this(message, status, LocalDateTime.now().toString(), path);
    }
}