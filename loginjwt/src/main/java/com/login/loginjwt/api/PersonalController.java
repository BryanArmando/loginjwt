package com.login.loginjwt.api;

import com.login.loginjwt.domain.Personal;
import com.login.loginjwt.repo.PersonalRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonalController {

    @Autowired
    private PersonalRepo personalRepo;

    @ApiOperation(value = "Obtener personal por sucursal"
            ,notes = "Este es un método privado que permite obtener la lista de empleados de cada una sucursal (se requiere token)")
    @GetMapping("/private/sucursal/{sucursalId}/personal")
    public List<Personal> listarpersonal(@PathVariable(value = "sucursalId") Integer sucursalId){
        return personalRepo.findBySucursalId(sucursalId);
    }

    @ApiOperation(value = "Obtener todo el personal"
            ,notes = "Este es un método privado que permite obtener la lista completa de empleados (se requiere token)")
    @GetMapping("/private/personal")
    public List<Personal> todopersonal(){
        return personalRepo.findAll();
    }

    /**
     * buscar personal por filtro de parecido entre nombre y apellido
     * @param name
     * @return
     */
    @ApiOperation(value = "Obtener personal por filtro de nombre"
            ,notes = "Este es un método privado que permite obtener una lista de empleados con mayor coincidencias del nombre asignado (se requiere token)")
    @GetMapping("/private/personalfilter/{name}")
    public List<Personal> listaProd(@PathVariable(value = "name") String name){
        return personalRepo.getPersonalFilterName(name);
    }
}
