package com.shawnking07.webeditor.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shawn
 */
@Component
@ConfigurationProperties(prefix = "dockerclient")
@Data
public class DockerClientProperties {
    private String url;
    private int connectionPoolSize;
}
