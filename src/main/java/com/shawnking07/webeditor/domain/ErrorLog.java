package com.shawnking07.webeditor.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author shawn
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ErrorLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private Long userId;

    @Column
    @NotNull
    private String path;

    @Column
    @NotNull
    private String exception;

    @Column
    @NotNull
    private String ip;

    @CreatedDate
    private LocalDateTime createTime;
}
