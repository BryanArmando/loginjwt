package com.login.loginjwt.api;

import com.login.loginjwt.domain.Proveedores;
import com.login.loginjwt.domain.Sucursales;
import com.login.loginjwt.exception.ResourceNotFoundException;
import com.login.loginjwt.repo.ProveedoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/private")
public class ProveedoresController {
    @Autowired
    private ProveedoresRepo proveedoresRepo;

    @GetMapping("/proveedor")
    public List<Proveedores> listarProveedores(){
        return proveedoresRepo.findAll();
    }

    @GetMapping("/proveedor/{id}")
    public Proveedores listarProveedorPorId(@PathVariable Integer id){
        return proveedoresRepo.findById(id).get();
    }

    @PostMapping("/proveedor")
    public Proveedores guardarProveedor(@Valid @RequestBody Proveedores proveedores){
        return proveedoresRepo.save(proveedores);
    }

    @PutMapping("/proveedor/{proveedorId}")
    public Proveedores actualizarSucursal(@PathVariable Integer proveedorId,@Valid @RequestBody Proveedores proveedorRequest) {
        return proveedoresRepo.findById(proveedorId).map(proveedor -> {
            proveedor.setNombreProveedor(proveedorRequest.getNombreProveedor());
            proveedor.setNumContactoProveedor(proveedorRequest.getNumContactoProveedor());
            proveedor.setDireccion(proveedorRequest.getDireccion());
            proveedor.setRuc(proveedorRequest.getRuc());
            return proveedoresRepo.save(proveedor);
        }).orElseThrow(() -> new ResourceNotFoundException("Proveedor con el ID : " + proveedorId + " no encontrada"));
    }

    @DeleteMapping("/proveedor/{proveedorId}")
    public ResponseEntity<?> eliminarPorveedor(@PathVariable Integer proveedorId){
        return proveedoresRepo.findById(proveedorId).map(proveedor -> {
            proveedoresRepo.delete(proveedor);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Proveedor con el ID : " + proveedorId + " no encontrada"));
    }
}
