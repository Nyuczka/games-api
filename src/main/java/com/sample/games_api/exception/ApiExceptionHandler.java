package com.sample.games_api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<Object> handleApiRequestException(HttpClientErrorException exception) {
        ApiException apiException =
                new ApiException(exception.getMessage(), HttpStatus.NOT_FOUND
                        , ZonedDateTime.now(ZoneId.of("Z")));
        LOGGER.error(apiException.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
