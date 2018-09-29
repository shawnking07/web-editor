package com.shawnking07.webeditor.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author shawn
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ErrorLog extends BaseEntity {
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
}
