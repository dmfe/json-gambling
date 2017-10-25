package com.nc.jackson;

import com.nc.jackson.annotations.AnnotationsTest;
import com.nc.jackson.marshalling.MarshallingTest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure(Main.class.getClassLoader().getResourceAsStream("log4j.properties"));
        new Main().start();
    }

    private void start() throws Exception {
        log.info("Main started...");
        new AnnotationsTest().run();
        new MarshallingTest().run();
    }
}