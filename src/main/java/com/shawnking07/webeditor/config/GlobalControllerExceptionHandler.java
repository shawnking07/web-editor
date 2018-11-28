package com.shawnking07.webeditor.config;

import com.shawnking07.webeditor.bean.ErrorInfo;
import com.shawnking07.webeditor.exception.ConflictException;
import com.shawnking07.webeditor.exception.SysRuntimeException;
import com.shawnking07.webeditor.service.ErrorLogService;
import com.shawnking07.webeditor.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ErrorLogService errorLogService;

    @Autowired
    public GlobalControllerExceptionHandler(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SysRuntimeException.class)
    @ResponseBody
    public ErrorInfo handleSysRuntime(HttpServletRequest request, Exception e) {
        errorLogService.create(e, request.getRemoteAddr(), UserUtil.getCurrentUserIdFromRequest(), request.getRequestURL().toString());
        return new ErrorInfo(Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getLocalizedMessage(),
                request.getRequestURI());
    }
}
