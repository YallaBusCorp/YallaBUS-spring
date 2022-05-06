package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.DriverInfoDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.DriverInfo;
import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.entity.LkEmployee;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.DriverInfoService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.LkEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/driverInfo")
public class DriverInfoController {

    @Autowired
    private DriverInfoService driverInfoService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LkEmployeeService lkEmployeeService;
    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<DriverInfo> getAllDriverInfos() {
        return driverInfoService.getAllDriverInfos();
    }


    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public DriverInfo getDriverInfoById(@RequestParam("id") int driverInfoId) {
        return driverInfoService.getDriverInfoById(driverInfoId);
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<DriverInfo> getAllActiveDriverInfoById(@RequestParam("id") int companyId) {
        return driverInfoService.getAllActiveDriverInfosByCompanyId(companyId);
    }

    @PostMapping("/save-driverInfo")
    public DriverInfo save(@RequestBody DriverInfoDTO driverInfoDTO) {
        DriverInfo driverInfo = new DriverInfo();
        driverInfoDTO.setDriverLicenceExpirationDateAlarm(driverInfoDTO.getDriverLicenceExpirationDate().minusMonths(1));
        Employee employee = new Employee();
        employee.setEmpCode(driverInfoDTO.getEmp().getEmpCode());
        employee.setEmpName(driverInfoDTO.getEmp().getEmpName());
        employee.setEmpPhone(driverInfoDTO.getEmp().getEmpPhone());
        employee.setEmpNationalId(driverInfoDTO.getEmp().getEmpNationalId());
        employee.setEmpSalary(driverInfoDTO.getEmp().getEmpSalary());
        employee.setEmpStartDate(driverInfoDTO.getEmp().getEmpStartDate());
        employee.setEmpEndDate(null);
        Company company = companyService.getCompanyById(driverInfoDTO.getEmp().getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(driverInfoDTO.getEmp().getEmpLk().getId());
        employee.setEmpLk(lkEmployee);
        Employee result = employeeService.save(employee);
        driverInfo.setEmp(result);
        driverInfo.setDriverLicenceNumber(driverInfoDTO.getDriverLicenceNumber());
        driverInfo.setDriverLicenceExpirationDate(driverInfoDTO.getDriverLicenceExpirationDate());
        driverInfo.setDriverLicenceExpirationDateAlarm(driverInfoDTO.getDriverLicenceExpirationDateAlarm());

        return driverInfoService.save(driverInfo);
    }

    @PutMapping("update-driverInfo")
    public DriverInfo update(@RequestBody DriverInfoDTO driverInfoDTO) {
        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setId(driverInfoDTO.getId());
        driverInfoDTO.setDriverLicenceExpirationDateAlarm(driverInfoDTO.getDriverLicenceExpirationDate().minusMonths(1));
        Employee employee = new Employee();
        employee.setId(driverInfoDTO.getEmp().getId());
        employee.setEmpCode(driverInfoDTO.getEmp().getEmpCode());
        employee.setEmpName(driverInfoDTO.getEmp().getEmpName());
        employee.setEmpPhone(driverInfoDTO.getEmp().getEmpPhone());
        employee.setEmpNationalId(driverInfoDTO.getEmp().getEmpNationalId());
        employee.setEmpSalary(driverInfoDTO.getEmp().getEmpSalary());
        employee.setEmpStartDate(driverInfoDTO.getEmp().getEmpStartDate());
        employee.setEmpEndDate(null);
        Company company = companyService.getCompanyById(driverInfoDTO.getEmp().getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(driverInfoDTO.getEmp().getEmpLk().getId());
        employee.setEmpLk(lkEmployee);
        Employee result = employeeService.save(employee);
        driverInfo.setEmp(result);
        driverInfo.setDriverLicenceNumber(driverInfoDTO.getDriverLicenceNumber());
        driverInfo.setDriverLicenceExpirationDate(driverInfoDTO.getDriverLicenceExpirationDate());
        driverInfo.setDriverLicenceExpirationDateAlarm(driverInfoDTO.getDriverLicenceExpirationDateAlarm());

        return driverInfoService.save(driverInfo);
    }

}