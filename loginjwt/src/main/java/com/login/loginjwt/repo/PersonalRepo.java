package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Personal;
import com.login.loginjwt.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonalRepo extends JpaRepository<Personal, Integer> {
    List<Personal> findBySucursalId(Integer sucursalId);

    @Query(value="select * from personal a where a.nombre LIKE :name% or a.apellido LIKE :name%", nativeQuery=true)
    List<Personal> getPersonalFilterName(String name);
}
