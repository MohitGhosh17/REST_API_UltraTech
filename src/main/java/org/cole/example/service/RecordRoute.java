package org.cole.example.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RecordRoute extends RouteBuilder {
    @Override
    public void configure() {
        // Routes are handled in Endpoint.java
    }
}
