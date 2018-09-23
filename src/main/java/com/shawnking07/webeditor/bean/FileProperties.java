package com.shawnking07.webeditor.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration for FileService
 *
 * @author shawn
 */
@Component
@ConfigurationProperties(prefix = "file-config")
@Data
public class FileProperties {
    private String basePath;
}
