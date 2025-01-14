package com.cabovianco.musicapi.exception.handler;

import com.cabovianco.musicapi.exception.ArtistNotFoundException;
import com.cabovianco.musicapi.exception.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors())
            map.put(error.getField(), error.getDefaultMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(map);
    }

    @ExceptionHandler(SongNotFoundException.class)
    ResponseEntity<Map<String, String>> handleSongNotFoundException(SongNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(map);
    }

    @ExceptionHandler(ArtistNotFoundException.class)
    ResponseEntity<Map<String, String>> handleArtistNotFoundException(ArtistNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(map);
    }

}
