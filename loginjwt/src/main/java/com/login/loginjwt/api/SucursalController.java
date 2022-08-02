package com.login.loginjwt.api;

import com.login.loginjwt.domain.Sucursales;
import com.login.loginjwt.exception.ResourceNotFoundException;
import com.login.loginjwt.repo.SucursalRepo;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Obtener sucursales"
            ,notes = "Este es un método permite obtener datos de todas las sucursales de la cadena de farmacias")
    @GetMapping("/public/sucursal")
    public List<Sucursales> listarSucursales(){
        return sucursalRepo.findAll();
    }

    @ApiOperation(value = "Obtener sucursal por ID"
            ,notes = "Este es un método que permite obtener una sucursal dependiendo de su ID")
    @GetMapping("/public/sucursal/{sucursalId}")
    public Sucursales obtenerSucursalPorId(@PathVariable Integer sucursalId){
        return sucursalRepo.findById(sucursalId).get();
    }

    //se cambio a modelatribute para enviar datos de formulario en lugar de requesbody que recibe un json :c
    @ApiOperation(value = "Agregar sucursal"
            ,notes = "Este es un método privado que permite registrar una sucursal (se requiere token)")
    @PostMapping("/private/sucursal")
    public Sucursales guardarSucursal(@Valid @RequestBody Sucursales sucursal){
        return sucursalRepo.save(sucursal);
    }

    @ApiOperation(value = "Editar sucursal por ID"
            ,notes = "Este es un método privado que permite editar datos de un proveedor dependiendo de su ID (se requiere token)")
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

    @ApiOperation(value = "Eliminar sucursal por ID"
            ,notes = "Este es un método privado que permite eliminar una sucursal dependiendo de su ID (se requiere token)")
    @DeleteMapping("/private/sucursal/{sucursalId}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable Integer sucursalId){
        return sucursalRepo.findById(sucursalId).map(sucursal -> {
            sucursalRepo.delete(sucursal);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Sucursal con el ID : " + sucursalId + " no encontrada"));
    }
}
