package com.sample.games_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
class ApiException extends RuntimeException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timestamp;

}
