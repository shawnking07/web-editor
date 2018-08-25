package com.shawnking07.webeditor.config;

import com.shawnking07.webeditor.bean.ErrorInfo;
import com.shawnking07.webeditor.exception.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * @author shawn
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    @ResponseBody
    public ErrorInfo handleConflict(HttpServletRequest request, Exception e) {
        return new ErrorInfo(Instant.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getLocalizedMessage(),
                request.getRequestURI());
    }
}
