package com.github.peneksglazami.activemqcamelrestexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ActivemqToRestRouterTests {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.input.queue}")
    private String inputQueue;

    @Test
    void testActiveMQToRestRoute() throws InterruptedException {
        jmsTemplate.send(inputQueue, session -> session.createTextMessage("Hello!"));
        assertTrue(TargetController.countDownLatch.await(5, TimeUnit.SECONDS));
    }
}
