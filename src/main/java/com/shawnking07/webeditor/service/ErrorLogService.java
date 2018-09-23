package com.shawnking07.webeditor.service;

/**
 * System Error Log
 *
 * @author shawn
 */
public interface ErrorLogService {

    /**
     * Create log
     *
     * @param ex     exception
     * @param ip     ip address
     * @param userId user id
     * @param path   request path
     */
    void create(Throwable ex, String ip, Long userId, String path);
}
