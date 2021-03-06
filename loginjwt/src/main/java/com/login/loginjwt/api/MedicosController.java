package com.login.loginjwt.api;

import com.login.loginjwt.domain.Medicos;
import com.login.loginjwt.repo.MedicosRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class MedicosController {

    @Autowired
    private MedicosRepo medicosRepo;

    @ApiOperation(value = "Información sobre Medicos"
            ,notes = "Con este método obtiene información general sobre los médicos que dispone la cadena de farmacias FARMECC")
    @GetMapping("/medicos")
    public List<Medicos> listarmedicos(){
        return medicosRepo.findAll();
    }
}
