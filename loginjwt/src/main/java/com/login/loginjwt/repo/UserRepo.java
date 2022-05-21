package com.login.loginjwt.repo;

import com.login.loginjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username0);
}
