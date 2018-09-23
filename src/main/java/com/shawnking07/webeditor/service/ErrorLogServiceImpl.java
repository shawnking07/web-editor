package com.shawnking07.webeditor.service;

import com.shawnking07.webeditor.domain.ErrorLog;
import com.shawnking07.webeditor.repository.ErrorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        errorLog.setCreateTime(LocalDateTime.now());
        errorLog.setPath(path);
        errorLogRepository.save(errorLog);
    }
}
