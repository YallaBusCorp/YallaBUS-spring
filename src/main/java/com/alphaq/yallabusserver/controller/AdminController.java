package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.AdminService;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.dto.AdminDTO;
import com.alphaq.yallabusserver.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @RequestMapping(value = "get-by-id", method = RequestMethod.GET)
    public Admin getAdminById(@RequestParam("id") int adminId) {
        return adminService.getAdminById(adminId);
    }

    @PostMapping("save-admin")
    public Admin save(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin();
        return adminService.save(admin);
    }


}