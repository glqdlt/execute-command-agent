package com.glqdlt.pm6.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@Slf4j
@RestController
public class SystemHandleRestController {
    @Autowired
    private SimpleSystemHandler handler;

    @GetMapping("/api/v1/system/shutdown")
    public ResponseEntity postShutdown(@RequestParam(required = false) Integer second) {
        Integer shutdownSeconds = Optional.ofNullable(second).orElse(30);
        try (OutputStream outputStream = new ByteArrayOutputStream(1024);) {
            handler.shutdown(shutdownSeconds, outputStream);
            String consolePrint = outputStream.toString();
            return ResponseEntity.status(HttpStatus.OK).body(consolePrint);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
