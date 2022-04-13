package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.LkTownDAO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.dto.LkTownDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://yalla-bus.herokuapp.com/", maxAge = 3600)
@RestController
public class LkTownController {

    @Autowired
    private LkTownDAO lkTownDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/lkTown/get-all")
    public List<LkTown> getAllLkTowns() {
        return lkTownDAO.getAllLkTowns();
    }

    @RequestMapping(value = "/lkTown/get-by-company-id", method = RequestMethod.GET)
    public List<LkTown> findLkTownsByCompanyId(@RequestParam("id") int companyId){
        return lkTownDAO.findLkTownsByCompanyId(companyId);
    }

    @RequestMapping(value = "/lkTown/get-by-id", method = RequestMethod.GET)
    public LkTown getTownById(@RequestParam("id") int townId) {
        return lkTownDAO.getLKTownById(townId);
    }

    @PostMapping("/lkTown/save-lk-town")
    public LkTown save(@RequestBody LkTownDTO lkTownDTO) {
        LkTown lkTown = new LkTown();
        lkTown.setTownName(lkTownDTO.getTownName());
        Company company = companyDAO.getCompanyById(lkTownDTO.getCompany().getId());
        lkTown.setCompany(company);
        return lkTownDAO.save(lkTown);
    }

}
