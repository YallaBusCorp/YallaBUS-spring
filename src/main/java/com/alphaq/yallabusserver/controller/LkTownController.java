package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.LkTownDAO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.dto.LkTownDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/lkTown/get-by-id", method = RequestMethod.GET)
    public LkTown getTownById(@RequestParam("id") int townId) {
        LkTownDTO lkTownDTO = new LkTownDTO();
        lkTownDTO.setId(townId);
        LkTown lkTown = new LkTown();
        lkTown.setId(lkTownDTO.getId());
        Optional<LkTown> optional = lkTownDAO.getLKTownById(lkTown);
        if (optional.isPresent())
            lkTown = optional.get();
        return lkTown;
    }

    @PostMapping("/lkTown/save-lk-town")
    public LkTown save(@RequestBody LkTownDTO lkTownDTO) {
        LkTown lkTown = new LkTown();
        int count = lkTownDAO.getCount();
        lkTown.setId(++count);
        lkTown.setTownName(lkTownDTO.getTownName());
        Company company = new Company();
        List<Company> companies = companyDAO.getAllCompanies();
        for (Company element : companies) {
            if (element.getId() == lkTownDTO.getCompany().getId()) {
                company = element;
                break;
            }
        }
        lkTown.setCompany(company);
        return lkTownDAO.save(lkTown);
    }

}
