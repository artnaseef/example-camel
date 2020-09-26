package com.artnaseef.example.camel.simplemain;

import com.artnaseef.example.camel.simplemain.routes.SimpleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.component.dataset.ListDataSet;
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
        this.setupDataSets();

        this.camelContext.start();
        this.camelContext.addService("");

        Thread.sleep(3000);
    }

    private void setupRegistry() {
        this.camelBeanRegistry = new SimpleRegistry();
    }

    private void setupRoutes() throws Exception {
        SimpleRoute simpleRoute = new SimpleRoute();
        this.camelContext.addRoutes(simpleRoute);
    }

    private void setupDataSets() throws Exception {
        ListDataSet listDataSet = new ListDataSet();

        listDataSet.setDefaultBodies(
                Arrays.asList("body.001", "body.002", "body.003", "body.004")
        );

        this.camelBeanRegistry.put("test-data", listDataSet);
    }
}
