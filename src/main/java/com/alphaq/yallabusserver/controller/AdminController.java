package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.AdminDAO;
import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dto.AdminDTO;
import com.alphaq.yallabusserver.entity.Admin;
import com.alphaq.yallabusserver.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/admin/get-all")
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    @RequestMapping(value = "/admin/get-by-id", method = RequestMethod.GET)
    public Admin getAdminById(@RequestParam("id") int adminId) {
        return adminDAO.getAdminById(adminId);
    }

    @PostMapping("/admin/save-admin")
    public Admin save(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin();
        return adminDAO.save(admin);
    }


}