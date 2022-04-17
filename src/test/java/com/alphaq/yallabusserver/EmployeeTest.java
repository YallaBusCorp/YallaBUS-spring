package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dto.CompanyDTO;
import com.alphaq.yallabusserver.dto.EmployeeDTO;
import com.alphaq.yallabusserver.dto.LkEmployeeDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.entity.LkEmployee;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.LkEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LkEmployeeService lkEmployeeService;
    @Autowired
    CompanyService companyService;

    @Test
    void saveEmployee(){
        int companyId = 1;
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(companyId);

        int roleId = 1;
        LkEmployeeDTO lkEmployeeDTO = new LkEmployeeDTO();
        lkEmployeeDTO.setId(roleId);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpCode("2592mou");
        employeeDTO.setEmpName("مصطفي ابراهيم");
        employeeDTO.setEmpPhone("01067893079");
        employeeDTO.setEmpNationalId("30009251205975");
        employeeDTO.setEmpSalary(5000);
        employeeDTO.setCompany(companyDTO);
        employeeDTO.setEmpLk(lkEmployeeDTO);



        Employee employee = new Employee();
        employee.setEmpCode(employeeDTO.getEmpCode());
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpPhone(employeeDTO.getEmpPhone());
        employee.setEmpNationalId(employeeDTO.getEmpNationalId());
        employee.setEmpSalary(employeeDTO.getEmpSalary());
        Company company = companyService.getCompanyById(employeeDTO.getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(employeeDTO.getEmpLk().getId());
        employee.setEmpLk(lkEmployee);

        Employee result = employeeService.save(employee);
        System.out.println(result);


    }
}
