package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.dto.EmployeeDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Employee> getEmployeesByCompanyId(@RequestParam("id") int companyId) {
        return employeeService.getEmployeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Employee getEmployeeById(@RequestParam("id") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/save-employee")
    public Employee save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        Company company = companyService.getCompanyById(employeeDTO.getCompany().getId());
        employee.setCompany(company);
        return employeeService.save(employee);
    }


}