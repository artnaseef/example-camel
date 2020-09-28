package com.artnaseef.example.camel.simplemain;

import com.artnaseef.example.camel.simplemain.routes.ControlBusRoute;
import com.artnaseef.example.camel.simplemain.routes.SimpleHelloHttpRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

import java.util.Arrays;

/**
 * Created by art on 2/15/19.
 */
public class Main {

    private CamelContext camelContext;
    private SimpleRegistry camelBeanRegistry;

    public static void main(String[] args) {
        Main instance = new Main();

        try {
            instance.instanceMain(args);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void instanceMain(String[] args) throws Exception {
        this.setupRegistry();

        this.camelContext = new DefaultCamelContext(this.camelBeanRegistry);

        this.setupRoutes();

        this.camelContext.start();
        this.camelContext.addService("");

        Thread.sleep(3000);
    }

    private void setupRegistry() {
        this.camelBeanRegistry = new SimpleRegistry();
    }

    private void setupRoutes() throws Exception {
        SimpleHelloHttpRoute simpleHelloHttpRoute = new SimpleHelloHttpRoute();
        this.camelContext.addRoutes(simpleHelloHttpRoute);

        ControlBusRoute simpleRoute = new ControlBusRoute();
        this.camelContext.addRoutes(simpleRoute);
    }
}
