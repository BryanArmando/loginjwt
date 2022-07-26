package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedoresRepo extends JpaRepository<Proveedores, Integer> {

    List<Proveedores> findByProveedorId(Integer proveedorId);

}
