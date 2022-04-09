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

    @GetMapping("/LkTown/get-all")
    public List<LkTown> getAllLkTowns() {
        return lkTownDAO.getAllLkTowns();
    }

    @GetMapping("/LkTown/get-by-id")
    public LkTown getTownById(@RequestBody LkTownDTO lkTownDTO) {
        LkTown lkTown = new LkTown();
        lkTown.setId(lkTownDTO.getId());
        Optional<LkTown> optional = lkTownDAO.getLKTownById(lkTown);
        if (optional.isPresent())
            lkTown = optional.get();
        return lkTown;
    }

    @PostMapping("/LkTown/save-lk-town")
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
