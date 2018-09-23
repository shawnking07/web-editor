package com.shawnking07.webeditor.exception;

/**
 * @author shawn
 */
public class SysRuntimeException extends RuntimeException {
    public SysRuntimeException(String message) {
        super(message);
    }

    public SysRuntimeException(Throwable ex) {
        super(ex);
    }
}
