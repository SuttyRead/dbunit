package com.ua.sutty.dbunit.repository;

import com.ua.sutty.dbunit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    void deleteUserById(Long id);
}
