package com.artnaseef.example.camel.simplemain.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHelloHttpRoute extends RouteBuilder {
    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(SimpleHelloHttpRoute.class);

    private Logger log = DEFAULT_LOGGER;

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:8080/hi")
                .routeId("hi-http-route")
                .log("HELLO")
                .setBody(constant("Hello back"))
                ;
    }
}
