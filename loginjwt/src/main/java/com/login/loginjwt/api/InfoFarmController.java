package com.login.loginjwt.api;

import com.login.loginjwt.domain.InfoFarmecc;
import com.login.loginjwt.repo.InfoFarmeccRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class InfoFarmController {

    @Autowired
    private InfoFarmeccRepo infoFarmeccRepo;

    @ApiOperation(value = "Información sobre FARMECC"
            ,notes = "Con este método obtiene información general sobre la farmacia")
    @GetMapping("/infoPage")
    public List<InfoFarmecc> informacion(){
        return infoFarmeccRepo.findAll();
    }
}
