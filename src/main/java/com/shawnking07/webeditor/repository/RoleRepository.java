package com.shawnking07.webeditor.repository;

import com.shawnking07.webeditor.domain.Role;
import com.shawnking07.webeditor.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shawn
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
