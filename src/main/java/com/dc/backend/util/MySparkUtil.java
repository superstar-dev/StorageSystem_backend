package com.dc.backend.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class MySparkUtil {
    private static final String SPARK_PROPERTIES = "/spark.properties";

    private static String master;
    private static String sparkPort;

    static {
        Properties p = new Properties();
        try {
            p.load(MySparkUtil.class.getResourceAsStream(SPARK_PROPERTIES));
            master = p.getProperty("master");
            sparkPort = p.getProperty("spark_port");
        } catch (IOException e) {
            log.error("can not read from spark.properties:{}", e.getMessage());
        }
    }
}
