package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/company/get-all")
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @RequestMapping(value = "/company/get-by-id", method = RequestMethod.GET)
    public Company getAllCompanies(@RequestParam("id") int companyId) {
        return companyDAO.getCompanyById(companyId);
    }

    @PostMapping("/company/save-company")
    public Company save(@RequestBody CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCompanyName(companyDTO.getCompanyName());
        return companyDAO.save(company);
    }


}
