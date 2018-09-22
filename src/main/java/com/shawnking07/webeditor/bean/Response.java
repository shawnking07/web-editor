package com.shawnking07.webeditor.bean;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * @author shawn
 */
@Data
public class Response {
    private Instant timestamp;
    private Integer status;
    private Object data;

    public static Response ok(Object data) {
        Response response = new Response();
        response.setTimestamp(Instant.now());
        response.setStatus(HttpStatus.OK.value());
        response.setData(data);
        return response;
    }

    public static Response ok() {
        Response response = new Response();
        response.setTimestamp(Instant.now());
        response.setStatus(HttpStatus.OK.value());
        response.setData("success");
        return response;
    }
}
