package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Productos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Productos, Integer> {

    List<Productos> findBySucursalId(Integer sucursalId);

    Optional<Productos> findByIdAndSucursalId(Integer productoId, Integer sucursalId);
/*
    @Query(value = "select productos.id, productos.nombre_comercial, productos.nombre_generico  FROM productos",
    nativeQuery = true)
    List<Productos> forClientesProd();

 */

    @Query(value="select * from productos a where a.nombre_generico LIKE :name% or a.nombre_comercial LIKE :name%", nativeQuery=true)
    List<Productos> getProductosFilterName(String name);

}
