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
    public List<LkUniversity> getAllLkUniversities() {
        return lkUniversityService.getAllLkUniversities();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<LkUniversity> getAllLkUniversitiesByCompanyId(@RequestParam("id") int companyId) {
        return lkUniversityService.getAllLkUniversitiesByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<LkUniversity> getAllActiveLkUniversitiesByCompanyId(@RequestParam("id") int companyId) {
        return lkUniversityService.getAllActiveLkUniversityByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LkUniversity getUniversityById(@RequestParam("id") int universityId) {
        return lkUniversityService.getLkUniversityById(universityId);
    }

    @PostMapping("/save-lk-university")
    public LkUniversity save(@RequestBody LkUniversityDTO lkUniversityDTO) {
        LkUniversity lkUniversity = new LkUniversity();
        lkUniversity.setUniversityName(lkUniversityDTO.getUniversityName());
        lkUniversity.setIsActive(true);
        Company company = companyService.getCompanyById(lkUniversityDTO.getCompany().getId());
        lkUniversity.setCompany(company);
        return lkUniversityService.save(lkUniversity);
    }

    @PutMapping("/delete-lk-university")
    public Boolean delete(@RequestParam("id") int id) {
        LkUniversity lkUniversity = lkUniversityService.getLkUniversityById(id);
        lkUniversity.setIsActive(false);
        lkUniversity = lkUniversityService.save(lkUniversity);
        boolean flag = !lkUniversity.getIsActive() ? true : false;
        return flag;
    }

}
