package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.LkUniversityService;
import com.alphaq.yallabusserver.dto.LkUniversityDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/lkUniversity")
public class LkUniversityController {

    @Autowired
    private LkUniversityService lkUniversityService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<LkUniversity> getAllLkUniversities(){
        return lkUniversityService.getAllLkUniversities();
    }

    @RequestMapping(value = "/get-by-company-id", method = RequestMethod.GET)
    public List<LkUniversity> getLkUniversitiesByCompanyId(@RequestParam("id") int companyId){
        return lkUniversityService.getLkUniversitiesByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LkUniversity getUniversityById(@RequestParam("id") int universityId){
        return lkUniversityService.getLkUniversityById(universityId);
    }

    @PostMapping("/save-lk-university")
    public LkUniversity save(@RequestBody LkUniversityDTO lkUniversityDTO){
        LkUniversity lkUniversity = new LkUniversity();
        lkUniversity.setUniversityName(lkUniversityDTO.getUniversityName());
        Company company = companyService.getCompanyById(lkUniversityDTO.getCompany().getId());
        lkUniversity.setCompany(company);
        return lkUniversityService.save(lkUniversity);
    }

}
