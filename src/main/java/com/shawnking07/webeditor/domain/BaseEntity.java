package com.shawnking07.webeditor.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author shawn
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdTime", "updatedTime", "isActive"},
        allowGetters = true
)
@Where(clause = "is_active = true")
@SQLDelete(sql = "UPDATE user SET is_active = false WHERE id=?")
abstract class BaseEntity implements Serializable {
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(nullable = false)
    private Boolean isActive = true;
}
