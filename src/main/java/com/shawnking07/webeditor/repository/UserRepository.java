package com.shawnking07.webeditor.repository;

import com.shawnking07.webeditor.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shawn
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Login check
     * @param username Username
     * @param password Password
     * @return isExist
     */
    Boolean existsByUsernameAndPassword(String username, String password);

    /**
     * Search by username which is unique
     * @param username Username
     * @return Optional
     */
    Optional<User> findByUsername(String username);
}
