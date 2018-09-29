package com.shawnking07.webeditor.config;

import com.shawnking07.webeditor.exception.SysRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author shawn
 */
@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error(method.getName(), ex);
        throw new SysRuntimeException(ex);
    }
}
