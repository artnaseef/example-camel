package com.artnaseef.example.camel.jms.transacted;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by art on 2/15/19.
 */
public class ExampleCamelJmsTransactedRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("amq-in:camel-jms-transacted.request")
            .log("HAVE AMQ MESSAGE")
            ;

        from("timer://trigger-amq-route?fixedRate=true&period=5000")
            .setBody(constant("amq-test-message-body"))
            .to("amq-test-out?disableReplyTo=true&jmsMessageType=text")
            ;
    }
}
