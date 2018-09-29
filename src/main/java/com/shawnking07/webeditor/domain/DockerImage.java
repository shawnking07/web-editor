package com.shawnking07.webeditor.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author shawn
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class DockerImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imageId;

    @Column(nullable = false)
    @Size(max = 64)
    private String name;

}
