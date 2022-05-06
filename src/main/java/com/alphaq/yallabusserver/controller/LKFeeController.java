package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.BusDTO;
import com.alphaq.yallabusserver.dto.LKFeeDTO;
import com.alphaq.yallabusserver.entity.Bus;
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

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LKFee getLKFeeById(@RequestParam("id") int lKFeeId) {
        return lKFeeService.getLKFeeById(lKFeeId);
    }

    @PostMapping("/save-lKFee")
    public LKFee save(@RequestBody LKFeeDTO lKFeeDTO) {
        LKFee lKFee = new LKFee();

        if (lKFeeDTO.getId() != null)
            lKFee.setId(lKFeeDTO.getId());

        lKFee.setLkNameAr(lKFeeDTO.getLkNameAr());
        lKFee.setLkNameEn(lKFeeDTO.getLkNameEn());

        return lKFeeService.save(lKFee);
    }

    @PutMapping("/update-lKFee")
    public LKFee update(@RequestBody LKFeeDTO lKFeeDTO) {
        return save(lKFeeDTO);
    }

    @DeleteMapping("/delete-lKFee")
    public void delete(@RequestParam("id") int lkFeeId) {
        LKFee lKFee = lKFeeService.getLKFeeById(lkFeeId);
        lKFeeService.delete(lKFee);
    }


}