package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.EmployeeDAO;
import com.alphaq.yallabusserver.dto.EmployeeDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @RequestMapping(value = "/employee/get-by-company-id", method = RequestMethod.GET)
    public List<Employee> getEmployeesByCompanyId(@RequestParam("id") int companyId) {
        return employeeDAO.getEmployeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/employee/get-by-id", method = RequestMethod.GET)
    public Employee getEmployeeById(@RequestParam("id") int employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    @PostMapping("/employee/save-employee")
    public Employee save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        Company company = companyDAO.getCompanyById(employeeDTO.getCompany().getId());
        employee.setCompany(company);
        return employeeDAO.save(employee);
    }


}