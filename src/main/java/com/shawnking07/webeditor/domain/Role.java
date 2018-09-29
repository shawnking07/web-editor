package com.shawnking07.webeditor.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author shawn
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Role extends BaseEntity {
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
