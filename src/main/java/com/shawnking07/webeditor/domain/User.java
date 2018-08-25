package com.shawnking07.webeditor.domain;

import com.shawnking07.webeditor.viewmodel.UserViewModel;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shawn
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "is_active = true")
@SQLDelete(sql = "UPDATE user SET is_active = false WHERE id=?")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(max = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column
    private Boolean isActive = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(UserViewModel userViewModel) {
        this.username = userViewModel.getUsername();
        this.password = userViewModel.getPassword();
    }
}
