package com.shawnking07.webeditor.repository;

import com.shawnking07.webeditor.domain.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shawn
 */
@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}
