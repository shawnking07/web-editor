package com.shawnking07.webeditor.service.impl;

import com.shawnking07.webeditor.domain.ErrorLog;
import com.shawnking07.webeditor.repository.ErrorLogRepository;
import com.shawnking07.webeditor.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author shawn
 */
@Service
public class ErrorLogServiceImpl implements ErrorLogService {
    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorLogServiceImpl(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    @Override
    public void create(Throwable ex, String ip, Long userId, String path) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setException(ex.toString());
        errorLog.setIp(ip);
        errorLog.setUserId(userId);
        errorLog.setCreateDate(Instant.now());
        errorLog.setPath(path);
        errorLogRepository.save(errorLog);
    }
}
