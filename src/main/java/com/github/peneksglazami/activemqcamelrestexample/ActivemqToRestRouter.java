package com.github.peneksglazami.activemqcamelrestexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActivemqToRestRouter extends RouteBuilder {

    @Value("${jms.input.queue}")
    private String inputQueue;

    @Override
    public void configure() {
        from("activemq:" + inputQueue)
                .to("rest:post:message");
    }

}
