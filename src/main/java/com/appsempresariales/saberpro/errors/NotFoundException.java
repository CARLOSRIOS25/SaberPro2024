package com.appsempresariales.saberpro.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5321234241234124L;

    public NotFoundException(String message) {
        super(message);
    }
}