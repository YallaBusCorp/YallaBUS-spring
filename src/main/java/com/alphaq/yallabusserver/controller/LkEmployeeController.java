package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.LkEmployeeService;
import com.alphaq.yallabusserver.dto.LkEmployeeDTO;
import com.alphaq.yallabusserver.entity.LkEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/lkEmployee")
public class LkEmployeeController {

    @Autowired
    private LkEmployeeService lkEmployeeService;


    @GetMapping
    public List<LkEmployee> getAllLkEmployees() {
        return lkEmployeeService.getAllLkEmployees();
    }


    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public LkEmployee getLkEmployeeById(@RequestParam("id") int lkEmployeeId) {
        return lkEmployeeService.getLkEmployeeById(lkEmployeeId);
    }

    @PostMapping("/save-lk-Employee")
    public LkEmployee save(@RequestBody LkEmployeeDTO lkEmployeeDTO) {
        LkEmployee lkEmployee = new LkEmployee();


        return lkEmployeeService.save(lkEmployee);
    }


}