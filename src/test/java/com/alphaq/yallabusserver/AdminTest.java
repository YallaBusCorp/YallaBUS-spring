package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dto.AdminDTO;
import com.alphaq.yallabusserver.dto.CompanyDTO;
import com.alphaq.yallabusserver.dto.EmployeeDTO;
import com.alphaq.yallabusserver.dto.LkEmployeeDTO;
import com.alphaq.yallabusserver.entity.Admin;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.entity.LkEmployee;
import com.alphaq.yallabusserver.service.AdminService;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.LkEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class AdminTest {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    LkEmployeeService lkEmployeeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    AdminService adminService;

    //@Test
    public void addAdmin(){
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

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUsername("mou");
        adminDTO.setPassword("2592");
        adminDTO.setAccessToken("94646ads4d");
        adminDTO.setEmp(employeeDTO);


        Employee employee = new Employee();
        employee.setEmpCode(adminDTO.getEmp().getEmpCode());
        employee.setEmpName(adminDTO.getEmp().getEmpName());
        employee.setEmpPhone(adminDTO.getEmp().getEmpPhone());
        employee.setEmpNationalId(adminDTO.getEmp().getEmpNationalId());
        employee.setEmpSalary(adminDTO.getEmp().getEmpSalary());
        Company company = companyService.getCompanyById(adminDTO.getEmp().getCompany().getId());
        employee.setCompany(company);
        LkEmployee lkEmployee = lkEmployeeService.getLkEmployeeById(adminDTO.getEmp().getEmpLk().getId());
        employee.setEmpLk(lkEmployee);

        Employee result = employeeService.save(employee);

        Admin admin = new Admin();

        admin.setEmp(result);
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setAccessToken(adminDTO.getAccessToken());

        Admin adminResult = adminService.save(admin);
        System.out.println(adminResult);


    }
}
