package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.dto.EmployeeDTO;
import com.alphaq.yallabusserver.service.LkEmployeeService;
import com.alphaq.yallabusserver.service.TxRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    LkEmployeeService lkEmployeeService;
    @Autowired
    TxRideService txRideService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Employee> getAllEmployeesByCompanyId(@RequestParam("id") int companyId) {
        return employeeService.getAllEmployeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<Employee> getAllActiveEmployeesByCompanyId(@RequestParam("id") int companyId) {
        return employeeService.getAllActiveEmployeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/supervisor/active", method = RequestMethod.GET)
    public List<Employee> getAllActiveSupervisorByCompanyId(@RequestParam("id") int companyId) {
        return employeeService.getAllActiveEmployeeByLkEmployeeAndCompanyId(2, companyId);
    }

    @RequestMapping(value = "/company/driver/available", method = RequestMethod.GET)
    public List<Employee> getAllAvailableDriverByCompanyId(@RequestParam("id") int companyId) {
        List<Employee> availableEmployees = new ArrayList<>();
        List<Employee> employees = employeeService.getAllActiveEmployeeByLkEmployeeAndCompanyId(3, companyId);
        List<TxRide> txRides = txRideService.getAllTxRidesByCompanyIdAndRideStatusEqualsAndEmpIsNotNullAndBusIsNotNull(companyId, "process");
        boolean flag;
        for (Employee employee : employees) {
            flag = true;
            for (TxRide txRide : txRides) {
                if (employee.getId() == txRide.getEmp().getId())
                    flag = false;
            }
            if (flag)
                availableEmployees.add(employee);
        }
        return availableEmployees;
    }

    @RequestMapping(value = "/supervisor/get-by-id", method = RequestMethod.GET)
    public Employee getSupervisorById(@RequestParam("id") int employeeId) {
        return employeeService.getEmployeeByIdAndEmpLk(employeeId, 2);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Employee getEmployeeById(@RequestParam("id") int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(value = "/get-by-empCode", method = RequestMethod.GET)
    public Employee getEmployeeByEmpCode(@RequestParam("empCode") String employeeCode) {
        return employeeService.getEmployeeByEmpCode(employeeCode);
    }

    @PostMapping("/save-employee")
    public Employee save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmpCode(employeeDTO.getEmpCode());
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpNationalId(employeeDTO.getEmpNationalId());
        employee.setEmpSalary(employeeDTO.getEmpSalary());
        employee.setEmpStartDate(employeeDTO.getEmpStartDate());
        employee.setEmpEndDate(null);
        Company company = companyService.getCompanyById(employeeDTO.getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(employeeDTO.getEmpLk().getId());
        employee.setEmpLk(lkEmployee);
        return employeeService.save(employee);
    }

    @PutMapping("/update-supervisor")
    public Employee update(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setEmpCode(employeeDTO.getEmpCode());
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpNationalId(employeeDTO.getEmpNationalId());
        employee.setEmpSalary(employeeDTO.getEmpSalary());
        employee.setEmpStartDate(employeeDTO.getEmpStartDate());
        employee.setEmpEndDate(null);
        Company company = companyService.getCompanyById(employeeDTO.getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(employeeDTO.getEmpLk().getId());
        employee.setEmpLk(lkEmployee);
        return employeeService.save(employee);
    }

    @PutMapping("/delete-employee")
    public Boolean delete(@RequestParam("id") int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        employee.setEmpEndDate(LocalDate.now());
        employeeService.save(employee);
        return employee.getEmpEndDate() != null ? true : false;
    }

    @RequestMapping(value = "/get-count/company/active", method = RequestMethod.GET)
    public int getCountByCompanyIdAndIsActive(@RequestParam("id") int companyId) {
        return employeeService.getCountByCompanyIdAndIsActive(companyId);
    }

}