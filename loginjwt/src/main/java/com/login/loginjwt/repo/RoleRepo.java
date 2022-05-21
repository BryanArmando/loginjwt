package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
