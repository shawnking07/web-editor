package com.shawnking07.webeditor.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author shawn
 */
@Data
@Entity
public class DockerImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imageId;

    @Column(nullable = false)
    @Size(max = 64)
    private String name;

}
