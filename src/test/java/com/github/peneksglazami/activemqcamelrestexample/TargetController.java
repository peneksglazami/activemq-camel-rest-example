package com.github.peneksglazami.activemqcamelrestexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class TargetController {

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    private final Logger log = LoggerFactory.getLogger(TargetController.class);

    @PostMapping("/message")
    public ResponseEntity<Void> logMessage(@RequestBody String message) {
        log.info("Receive message: " + message);
        countDownLatch.countDown();
        return ResponseEntity.ok().build();
    }
}
