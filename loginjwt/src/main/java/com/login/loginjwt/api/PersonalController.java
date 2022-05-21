package com.login.loginjwt.api;

import com.login.loginjwt.domain.Personal;
import com.login.loginjwt.repo.PersonalRepo;
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

    @GetMapping("/private/sucursal/{sucursalId}/personal")
    public List<Personal> listarpersonal(@PathVariable(value = "sucursalId") Integer sucursalId){
        return personalRepo.findBySucursalId(sucursalId);
    }

    @GetMapping("/private/personal")
    public List<Personal> todopersonal(){
        return personalRepo.findAll();
    }
}
