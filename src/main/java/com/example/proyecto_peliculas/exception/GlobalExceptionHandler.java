package com.example.proyecto_peliculas.Exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(PeliculaNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePeliculaNotFoundException(PeliculaNotFoundException ex) {
        Map<String, Object> response = Map.of(
                "success", false,
                "message", ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
