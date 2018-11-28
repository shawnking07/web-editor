package com.shawnking07.webeditor.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * @author shawn
 */
@Data
@Entity
public class ErrorLog {
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

    @Column
    @NotNull
    private Instant createDate;
}
