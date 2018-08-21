package com.shawnking07.webeditor.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shawn
 */
@Data
@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleName name;

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }
}
