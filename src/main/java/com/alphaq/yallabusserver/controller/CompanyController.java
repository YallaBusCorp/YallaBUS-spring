package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dto.CompanyDTO;
import com.alphaq.yallabusserver.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/company/get-all")
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @GetMapping("/company/get-by-id")
    public Company getAllCompanies(@RequestBody CompanyDTO companyDTO) {
        Company company = new Company();
        company.setId(companyDTO.getId());
        Optional< Company > optional = companyDAO.getCompanyById(company);
        if (optional.isPresent())
            company = optional.get();
        return company;
    }

    @PostMapping("/company/save-company")
    public Company save(@RequestBody CompanyDTO companyDTO){
        Company company = new Company();
        int count = (int)companyDAO.getCount();
        company.setId(++count);
        company.setCompanyName(companyDTO.getCompanyName());
        return companyDAO.save(company);
    }



}
