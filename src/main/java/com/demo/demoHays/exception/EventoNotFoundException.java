package com.demo.demoHays.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends Exception {

    public EventoNotFoundException(String message) {
        super(message);
    }
}
