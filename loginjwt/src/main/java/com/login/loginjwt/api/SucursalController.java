package com.login.loginjwt.api;

import com.login.loginjwt.domain.Sucursales;
import com.login.loginjwt.exception.ResourceNotFoundException;
import com.login.loginjwt.repo.SucursalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SucursalController {
    @Autowired
    private SucursalRepo sucursalRepo;

    @GetMapping("/public/sucursal")
    public List<Sucursales> listarSucursales(){
        return sucursalRepo.findAll();
    }

    @GetMapping("/public/sucursal/{sucursalId}")
    public Sucursales obtenerSucursalPorId(@PathVariable Integer sucursalId){
        return sucursalRepo.findById(sucursalId).get();
    }

    @PostMapping("/private/sucursal")
    public Sucursales guardarSucursal(@Valid @RequestBody Sucursales sucursal){
        return sucursalRepo.save(sucursal);
    }

    @PutMapping("/private/sucursal/{sucursalId}")
    public Sucursales actualizarSucursal(@PathVariable Integer sucursalId,@Valid @RequestBody Sucursales sucursalRequest) {
        return sucursalRepo.findById(sucursalId).map(sucursal -> {
            sucursal.setNombre(sucursalRequest.getNombre());
            sucursal.setCiudad(sucursalRequest.getCiudad());
            sucursal.setTelefono(sucursalRequest.getTelefono());
            sucursal.setDireccion(sucursalRequest.getDireccion());
            return sucursalRepo.save(sucursal);
        }).orElseThrow(() -> new ResourceNotFoundException("Publicacion con el ID : " + sucursalId + " no encontrada"));
    }

    @DeleteMapping("/private/sucursal/{sucursalId}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable Integer sucursalId){
        return sucursalRepo.findById(sucursalId).map(sucursal -> {
            sucursalRepo.delete(sucursal);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Sucursal con el ID : " + sucursalId + " no encontrada"));
    }
}
