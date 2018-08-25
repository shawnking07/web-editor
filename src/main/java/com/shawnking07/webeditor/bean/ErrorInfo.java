package com.shawnking07.webeditor.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author shawn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
