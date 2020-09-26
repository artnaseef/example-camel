package com.artnaseef.example.camel.simplemain.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRoute extends RouteBuilder {
    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(SimpleRoute.class);

    private Logger log = DEFAULT_LOGGER;

    @Override
    public void configure() throws Exception {
        from("scheduler://test-data")
                .setBody(constant("Scheduled Messsge"))
                .process(this::showMessage)
                ;

        from("dataset://test-data")
                .process(this::showMessage)
                ;
    }

    private void showMessage(Exchange exchange) {
        Object body = exchange.getIn().getBody();
        this.log.info("BODY = {}", body);
    }
}
