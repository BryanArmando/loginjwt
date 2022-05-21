package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepo extends JpaRepository<Medicos, Integer> {
}
