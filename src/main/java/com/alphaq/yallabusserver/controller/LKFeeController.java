package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.LKFeeDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LKFee;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.LKFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/lKFee")
public class LKFeeController {

    @Autowired
    private LKFeeService lKFeeService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<LKFee> getAllLKFees() {
        return lKFeeService.getAllLKFees();
    }

//    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
//    public List<LKFee> getAllLKFeesByCompanyId(@RequestParam("id") int companyId) {
//        return lKFeeService.getAllLKFeesByCompanyId(companyId);
//    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LKFee getLKFeeById(@RequestParam("id") int lKFeeId) {
        return lKFeeService.getLKFeeById(lKFeeId);
    }

//    @PostMapping("/save-lKFee")
//    public LKFee save(@RequestBody LKFeeDTO lKFeeDTO) {
//        LKFee lKFee = new LKFee();
//
//        Company company = companyService.getCompanyById(lKFeeDTO.getCompany().getId());
//        lKFee.setCompany(company);
//        return lKFeeService.save(lKFee);
//    }


}