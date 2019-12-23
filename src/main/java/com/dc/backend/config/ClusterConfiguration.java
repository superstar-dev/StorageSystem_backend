package com.dc.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "cluster")
@Component
public class ClusterConfiguration {
    private String host;
    private String port;
}
