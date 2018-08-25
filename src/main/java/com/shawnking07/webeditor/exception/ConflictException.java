package com.shawnking07.webeditor.exception;

/**
 * Business Exception
 *
 * @author shawn
 */
public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }
}
