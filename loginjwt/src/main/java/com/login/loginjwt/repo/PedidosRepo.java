package com.login.loginjwt.repo;

import com.login.loginjwt.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepo extends JpaRepository<Pedidos, Integer> {

}
