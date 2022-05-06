package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.AdminService;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.dto.AdminDTO;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.LkEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LkEmployeeService lkEmployeeService;
    @Autowired
    CompanyService companyService;

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
        Employee employee = new Employee();
        employee.setEmpCode(adminDTO.getEmp().getEmpCode());
        employee.setEmpName(adminDTO.getEmp().getEmpName());
        employee.setEmpPhone(adminDTO.getEmp().getEmpPhone());
        employee.setEmpNationalId(adminDTO.getEmp().getEmpNationalId());
        employee.setEmpSalary(adminDTO.getEmp().getEmpSalary());
        employee.setEmpStartDate(adminDTO.getEmp().getEmpStartDate());
        employee.setEmpEndDate(null);
        Company company = companyService.getCompanyById(adminDTO.getEmp().getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(adminDTO.getEmp().getEmpLk().getId());
        employee.setEmpLk(lkEmployee);
        Employee result = employeeService.save(employee);
        admin.setEmp(result);
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        return adminService.save(admin);
    }

    @PutMapping("/update-admin")
    public Admin update(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        Employee employee = new Employee();
        employee.setId(adminDTO.getEmp().getId());
        employee.setEmpCode(adminDTO.getEmp().getEmpCode());
        employee.setEmpName(adminDTO.getEmp().getEmpName());
        employee.setEmpPhone(adminDTO.getEmp().getEmpPhone());
        employee.setEmpNationalId(adminDTO.getEmp().getEmpNationalId());
        employee.setEmpSalary(adminDTO.getEmp().getEmpSalary());
        employee.setEmpStartDate(adminDTO.getEmp().getEmpStartDate());
        employee.setEmpEndDate(null);
        Company company = companyService.getCompanyById(adminDTO.getEmp().getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(adminDTO.getEmp().getEmpLk().getId());
        employee.setEmpLk(lkEmployee);
        Employee result = employeeService.save(employee);
        admin.setEmp(result);
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        return adminService.save(admin);
    }

}