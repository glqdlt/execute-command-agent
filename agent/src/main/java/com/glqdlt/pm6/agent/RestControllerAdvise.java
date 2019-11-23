package com.glqdlt.pm6.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@Slf4j
@RestControllerAdvice
public class RestControllerAdvise {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity catchAllError(Throwable t) {
        log.warn(t.getMessage(), t);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ExceptionHandler(NotAllowHeaderError.class)
    public ResponseEntity catchAllError(NotAllowHeaderError throwable) {
        log.error(throwable.getMessage(), throwable);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).build();
    }
}
