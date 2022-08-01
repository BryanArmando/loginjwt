package com.login.loginjwt.repo;

import com.login.loginjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username0);

    @Query(value="select * from user a where a.password = :pass AND a.username = :user", nativeQuery=true)
    List<User> getPVentaFilter(String pass, String user);
}
