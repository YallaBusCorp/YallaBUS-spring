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
    public List<LkTown> getAllLkTownsByCompanyId(@RequestParam("id") int companyId) {
        return lkTownService.getAllLkTownsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<LkTown> getAllActiveLkTownsByCompanyId(@RequestParam("id") int companyId) {
        return lkTownService.getAllActiveLkTownsByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LkTown getTownById(@RequestParam("id") int townId) {
        return lkTownService.getLKTownById(townId);
    }

    @PostMapping("/save-lk-town")
    public LkTown save(@RequestBody LkTownDTO lkTownDTO) {
        LkTown lkTown = new LkTown();
        lkTown.setTownName(lkTownDTO.getTownName());
        lkTown.setIsActive(true);
        Company company = companyService.getCompanyById(lkTownDTO.getCompany().getId());
        lkTown.setCompany(company);
        return lkTownService.save(lkTown);
    }

    @PutMapping("/delete-lk-town")
    public Boolean delete(@RequestParam("id") int id) {
        LkTown lkTown = lkTownService.getLKTownById(id);
        lkTown.setIsActive(false);
        lkTown = lkTownService.save(lkTown);
        boolean flag = !lkTown.getIsActive() ? true : false;
        return flag;
    }

}
