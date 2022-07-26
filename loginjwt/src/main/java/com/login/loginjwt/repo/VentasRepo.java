package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Personal;
import com.login.loginjwt.domain.Productos;
import com.login.loginjwt.domain.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasRepo extends JpaRepository<Ventas,Integer> {
    List<Ventas> findBySucursalId(Integer sucursalId);

    @Query(value="select * from ventas a where a.fecha_venta between :value1 AND :value2", nativeQuery=true)
    List<Ventas> getPVentaFilter(String value1, String value2);


    @Query(value="select * from ventas a where (a.fecha_venta between :value1 AND :value2) AND WHERE (a.surcursal_id :sucursalId )", nativeQuery=true)
    List<Ventas> getVentasIdFilter(String value1, String value2, Integer sucursalId);

}
