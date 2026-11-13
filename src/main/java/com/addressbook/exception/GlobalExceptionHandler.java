/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Converts application exceptions into meaningful HTTP responses.
 * Name: Utakarsh Jain
 * Date: 13/11/2026
 */

package com.addressbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle requests for contacts that do not exist
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleContactNotFound(
            ContactNotFoundException exception) {

        Map<String, String> errorResponse = Map.of(
                "error", "Contact Not Found",
                "message", exception.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}