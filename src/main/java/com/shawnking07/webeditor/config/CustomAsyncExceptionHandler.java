package com.shawnking07.webeditor.config;

import com.shawnking07.webeditor.exception.SysRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author shawn
 */
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(CustomAsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        logger.error(method.getName(), ex);
        throw new SysRuntimeException(ex);
    }
}
