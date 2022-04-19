package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dto.CompanyDTO;
import com.alphaq.yallabusserver.dto.DriverInfoDTO;
import com.alphaq.yallabusserver.dto.EmployeeDTO;
import com.alphaq.yallabusserver.dto.LkEmployeeDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.DriverInfo;
import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.entity.LkEmployee;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.DriverInfoService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.LkEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DriverInfoTest {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    LkEmployeeService lkEmployeeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    DriverInfoService driverInfoService;

    @Test
    void saveDriver(){
        int companyId = 1;
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(companyId);

        int roleId = 3;
        LkEmployeeDTO lkEmployeeDTO = new LkEmployeeDTO();
        lkEmployeeDTO.setId(roleId);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpCode("9641");
        employeeDTO.setEmpName("محمد احمد");
        employeeDTO.setEmpPhone("01042193034");
        employeeDTO.setEmpNationalId("30009351205941");
        employeeDTO.setEmpSalary(6000);
        employeeDTO.setCompany(companyDTO);
        employeeDTO.setEmpLk(lkEmployeeDTO);

        DriverInfoDTO driverInfoDTO = new DriverInfoDTO();
        driverInfoDTO.setEmp(employeeDTO);
        driverInfoDTO.setDriverLicenceNumber("4456asd");
        driverInfoDTO.setDriverLicenceExpirationDate(LocalDate.now().plusYears(1));
        driverInfoDTO.setDriverLicenceExpirationDateAlarm(driverInfoDTO.getDriverLicenceExpirationDate().minusMonths(1));

        Employee employee = new Employee();
        employee.setEmpCode(driverInfoDTO.getEmp().getEmpCode());
        employee.setEmpName(driverInfoDTO.getEmp().getEmpName());
        employee.setEmpPhone(driverInfoDTO.getEmp().getEmpPhone());
        employee.setEmpNationalId(driverInfoDTO.getEmp().getEmpNationalId());
        employee.setEmpSalary(driverInfoDTO.getEmp().getEmpSalary());
        Company company = companyService.getCompanyById(driverInfoDTO.getEmp().getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(driverInfoDTO.getEmp().getEmpLk().getId());
        employee.setEmpLk(lkEmployee);

        Employee result = employeeService.save(employee);

        DriverInfo driverInfo = new DriverInfo();

        driverInfo.setEmp(result);
        driverInfo.setDriverLicenceNumber(driverInfoDTO.getDriverLicenceNumber());
        driverInfo.setDriverLicenceExpirationDate(driverInfoDTO.getDriverLicenceExpirationDate());
        driverInfo.setDriverLicenceExpirationDateAlarm(driverInfoDTO.getDriverLicenceExpirationDateAlarm());

        DriverInfo driverInfoResult = driverInfoService.save(driverInfo);

        System.out.println(driverInfoResult);


    }
}
