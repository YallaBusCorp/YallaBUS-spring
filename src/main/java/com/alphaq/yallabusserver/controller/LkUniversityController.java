package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.LkUniversityDAO;
import com.alphaq.yallabusserver.dto.LkUniversityDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LkUniversityController {

    @Autowired
    private LkUniversityDAO lkUniversityDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/lkUniversity/get-all")
    public List<LkUniversity> getAllLkUniversities(){
        return lkUniversityDAO.getAllLkUniversities();
    }

    @RequestMapping(value = "/lkUniversity/get-by-company-id", method = RequestMethod.GET)
    public List<LkUniversity> getLkUniversitiesByCompanyId(@RequestParam("id") int companyId){
        return lkUniversityDAO.getLkUniversitiesByCompanyId(companyId);
    }

    @RequestMapping(value = "/lkUniversity/get-by-id", method = RequestMethod.GET)
    public LkUniversity getUniversityById(@RequestParam("id") int universityId){
        LkUniversity lkUniversity = new LkUniversity();
        lkUniversity.setId(universityId);
        Optional<LkUniversity> optional = lkUniversityDAO.getLkUniversityById(lkUniversity);
        if (optional.isPresent())
            lkUniversity = optional.get();
        return lkUniversity;
    }

    @PostMapping("/lkUniversity/save-lk-university")
    public LkUniversity save(@RequestBody LkUniversityDTO lkUniversityDTO){
        LkUniversity lkUniversity = new LkUniversity();
        lkUniversity.setUniversityName(lkUniversityDTO.getUniversityName());
        Company company = companyDAO.getCompanyById(lkUniversityDTO.getCompany().getId());
        lkUniversity.setCompany(company);
        return lkUniversityDAO.save(lkUniversity);
    }

}
