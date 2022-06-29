package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Company getAllCompanies(@RequestParam("id") int companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PostMapping("/save-company")
    public Company save(@RequestBody CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCompanyName(companyDTO.getCompanyName());
        company.setCompanyLocation(companyDTO.getCompanyLocation());
        company.setCompanyPhone(companyDTO.getCompanyPhone());
        company.setDescription(companyDTO.getDescription());
        company.setFacebookURL(companyDTO.getFacebookURL());
        company.setImgURL(companyDTO.getImgURL());
        return companyService.save(company);
    }


}
