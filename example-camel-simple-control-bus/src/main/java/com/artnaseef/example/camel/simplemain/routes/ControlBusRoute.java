package com.artnaseef.example.camel.simplemain.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlBusRoute extends RouteBuilder {
    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(ControlBusRoute.class);

    private Logger log = DEFAULT_LOGGER;

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:8080/start-route")
                .routeId("control-start-route")
                .log("START ROUTE ${header.X-ROUTE-ID}")
                .toD("controlbus:route?action=start&routeId=${header.X-ROUTE-ID}")
                ;

        from("jetty:http://0.0.0.0:8080/stop-route")
                .routeId("control-stop-route")
                .log("STOP ROUTE ${header.X-ROUTE-ID}")
                .toD("controlbus:route?action=stop&routeId=${header.X-ROUTE-ID}")
                ;

        from("jetty:http://0.0.0.0:8080/route-status")
                .routeId("control-route-status")
                .log("ROUTE STATUS ${header.X-ROUTE-ID}")
                .toD("controlbus:route?action=status&routeId=${header.X-ROUTE-ID}")
                ;
    }
}
