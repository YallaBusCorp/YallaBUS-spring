package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.LkEmployeeDAO;
import com.alphaq.yallabusserver.dto.LkEmployeeDTO;
import com.alphaq.yallabusserver.entity.LkEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LkEmployeeController {

    @Autowired
    private LkEmployeeDAO lkEmployeeDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/lkEmployee/get-all")
    public List<LkEmployee> getAllLkEmployees() {
        return lkEmployeeDAO.getAllLkEmployees();
    }
    

    @RequestMapping(value = "/lkEmployee/get-by-id", method = RequestMethod.GET)
    public LkEmployee getLkEmployeeById(@RequestParam("id") int lkEmployeeId) {
        return lkEmployeeDAO.getLkEmployeeById(lkEmployeeId);
    }

    @PostMapping("/lkEmployee/save-lkEmployee")
    public LkEmployee save(@RequestBody LkEmployeeDTO lkEmployeeDTO) {
        LkEmployee lkEmployee = new LkEmployee();


        return lkEmployeeDAO.save(lkEmployee);
    }


}