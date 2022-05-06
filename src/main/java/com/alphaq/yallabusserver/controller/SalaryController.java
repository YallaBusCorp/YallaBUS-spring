package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.SalaryDTO;
import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.entity.Salary;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Salary> getAllSalarys() {
        return salaryService.getAllSalaries();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Salary> getAllSalarysByCompanyId(@RequestParam("id") int companyId) {
        return salaryService.getAllSalariesInCompany(companyId);
    }

    @RequestMapping(value = "/company/received", method = RequestMethod.GET)
    public List<Salary> getAllReceivedSalariesInCompany(@RequestParam("id") int companyId){
        return salaryService.getAllReceivedSalariesInCompany(companyId);
    }

    @RequestMapping(value = "/company/not-received", method = RequestMethod.GET)
    public List<Salary> getAllNotReceivedSalariesInCompany(@RequestParam("id") int companyId){
        return salaryService.getAllNotReceivedSalariesInCompany(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Salary getSalaryById(@RequestParam("id") int salaryId) {
        return salaryService.getSalaryById(salaryId);
    }

    @PostMapping("company/save-salaries")
    public List<Salary> saveSalaries(@RequestParam("id") int companyId){
        List<Salary> salaries = new ArrayList<>();
        Salary salary;
        List<Employee> employees = employeeService.getAllActiveEmployeesByCompanyId(companyId);
        for (Employee employee: employees) {
            salary = new Salary();
            salary.setEmp(employee);
            salary.setEmpSalary(employee.getEmpSalary());
            salary.setSalaryDate(LocalDate.now().minusMonths(1));
            salary.setIsReceived(false);
            salaries.add(salaryService.save(salary));
        }
        return salaries;
    }

    @PutMapping("/update-salary")
    public Salary update(@RequestBody SalaryDTO salaryDTO) {
        Salary salary = new Salary();
        Employee employee = employeeService.getEmployeeById(salaryDTO.getEmp().getId());
        salary = salaryService.getSalaryById(salaryDTO.getId());
        if (salary.getId() != null)
            salary.setId(salaryDTO.getId());
        salary.setEmp(employee);
        salary.setEmpSalary(salaryDTO.getEmpSalary());
        salary.setSalaryDate(salaryDTO.getSalaryDate());
        salary.setIsReceived(salaryDTO.getIsReceived());

        return salaryService.save(salary);
    }

    @PutMapping("/salary-received")
    public Boolean received(@RequestParam("id") int salaryId) {
        Salary salary = salaryService.getSalaryById(salaryId);
        salary.setIsReceived(true);
        return salaryService.save(salary).getIsReceived();
    }


}