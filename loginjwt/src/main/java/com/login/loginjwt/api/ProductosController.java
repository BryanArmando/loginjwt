package com.login.loginjwt.api;

import com.login.loginjwt.domain.Productos;
import com.login.loginjwt.repo.ProductoRepo;
import com.login.loginjwt.repo.SucursalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductosController {

    @Autowired
    private ProductoRepo productoRepository;

    @Autowired
    private SucursalRepo sucursalRepository;

    @GetMapping("/public/sucursal/{sucursalId}/productos")
    public Page<Productos> listarProductosPorSucursal(@PathVariable(value = "sucursalId") Integer sucursalId, Pageable pageable){
        return productoRepository.findBySucursalId(sucursalId, pageable);
    }
    @GetMapping("/public/productos")
    public List<Productos> listarProductos(){
        return productoRepository.findAll();
    }


    @GetMapping("/public/productoscli")
    public List<Productos> listarlawea(){
        return productoRepository.forClientesProd();
    }
/*
    @GetMapping("/public/productoscli")
    public ResponseEntity<?> listarProdClientes(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoRepository.forClientesProd());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error: "+ e.getMessage());
        }
    }
 */

    @GetMapping("public/productosfilter/{name}")
    public List<Productos> listaProd(@PathVariable(value = "name") String name){
        return productoRepository.getProductosFilterName(name);
    }

}
