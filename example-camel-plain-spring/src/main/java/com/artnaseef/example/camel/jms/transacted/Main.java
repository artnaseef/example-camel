package com.artnaseef.example.camel.jms.transacted;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by art on 2/15/19.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/camel-context.xml");
        context.start();
    }
}
