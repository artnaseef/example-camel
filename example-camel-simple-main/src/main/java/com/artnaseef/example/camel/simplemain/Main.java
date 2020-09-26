package com.artnaseef.example.camel.simplemain;

import com.artnaseef.example.camel.simplemain.routes.SimpleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by art on 2/15/19.
 */
public class Main {

    public static void main(String[] args) {
        Main instance = new Main();

        try {
            instance.instanceMain(args);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void instanceMain(String[] args) throws Exception {
        CamelContext camelContext;

        camelContext = new DefaultCamelContext();

        SimpleRoute simpleRoute = new SimpleRoute();
        camelContext.addRoutes(simpleRoute);

        camelContext.start();

        Thread.sleep(3000);
    }
}
