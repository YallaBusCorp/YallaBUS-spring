package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.LkTownService;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.dto.LkTownDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/lkTown")
public class LkTownController {

    @Autowired
    private LkTownService lkTownService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<LkTown> getAllLkTowns() {
        return lkTownService.getAllLkTowns();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<LkTown> findLkTownsByCompanyId(@RequestParam("id") int companyId){
        return lkTownService.findLkTownsByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LkTown getTownById(@RequestParam("id") int townId) {
        return lkTownService.getLKTownById(townId);
    }

    @PostMapping("/save-lk-town")
    public LkTown save(@RequestBody LkTownDTO lkTownDTO) {
        LkTown lkTown = new LkTown();
        lkTown.setTownName(lkTownDTO.getTownName());
        Company company = companyService.getCompanyById(lkTownDTO.getCompany().getId());
        lkTown.setCompany(company);
        return lkTownService.save(lkTown);
    }

}
