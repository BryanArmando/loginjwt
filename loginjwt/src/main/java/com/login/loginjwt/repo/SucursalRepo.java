package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepo extends JpaRepository<Sucursales, Integer> {
}
