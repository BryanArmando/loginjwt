package com.login.loginjwt.api;

import com.login.loginjwt.domain.Pedidos;
import com.login.loginjwt.exception.ResourceNotFoundException;
import com.login.loginjwt.repo.PedidosRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidosController {

    @Autowired
    private PedidosRepo pedidosRepo;

    @ApiOperation(value = "Información sobre pedidos"
            ,notes = "Con este método obtiene información los pedidos")
    @GetMapping("/public/pedidos")
    public List<Pedidos> listaPedidos(){
        return pedidosRepo.findAll();
    }


    @ApiOperation(value = "Agregar pedidos"
            ,notes = "Este es un método privado que permite guardar pedidos (se requiere token)")
    @PostMapping("/private/pedidos")
    public Pedidos guardarPedidos(@Valid @RequestBody Pedidos pedidos){
        return pedidosRepo.save(pedidos);
    }


    @ApiOperation(value = "Editar pedidos"
            ,notes = "Este es un método privado que permite editar pedidos, asignando el ID del pedido a modificar (se requiere token)")
    @PutMapping("/private/pedidos/{pedidosId}")
    public Pedidos actualizarPedidos (@PathVariable Integer pedidosId,@Valid @RequestBody Pedidos pedidosRequest) {
        return pedidosRepo.findById(pedidosId).map(pedido -> {
            pedido.setProductoPedido(pedidosRequest.getProductoPedido());
            pedido.setCantidad(pedidosRequest.getCantidad());
            pedido.setProveedores(pedidosRequest.getProveedores());
            return pedidosRepo.save(pedido);
        }).orElseThrow(() -> new ResourceNotFoundException("Pedido con el ID : " + pedidosId + " no encontrada"));
    }


    @ApiOperation(value = "Eliminar pedidos"
            ,notes = "Este es un método privado que permite eliminar pedidos, asignando el ID del pedido a eliminar (se requiere token)")
    @DeleteMapping("/private/pedidos/{pedidosId}")
    public ResponseEntity<?> eliminarPedidos(@PathVariable Integer pedidosId){
        return pedidosRepo.findById(pedidosId).map(pedido -> {
            pedidosRepo.delete(pedido);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Pedido con el ID : " + pedidosId + " no encontrada"));
    }
}

