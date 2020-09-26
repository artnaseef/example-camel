package com.artnaseef.example.camel.simplemain.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.util.Objects;

public class SimpleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("scheduler://test-data")
                .process(this::showMessage)
                ;
    }

    private void showMessage(Exchange exchange) {
        Object body = exchange.getIn().getBody();
        System.out.println("BODY = " + Objects.toString(body));
    }
}
