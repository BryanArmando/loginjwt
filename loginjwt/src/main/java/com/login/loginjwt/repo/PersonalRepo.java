package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalRepo extends JpaRepository<Personal, Integer> {
    List<Personal> findBySucursalId(Integer sucursalId);
}
