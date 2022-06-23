package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employees::add);
        return employees;
    }

    public List<Employee> getAllEmployeesByCompanyId(int companyId) {
        return repository.findEmployeesByCompanyId(companyId);
    }

    public List<Employee> getAllActiveEmployeesByCompanyId(int companyId) {
        return repository.findEmployeesByCompanyIdAndEmpEndDateIsNull(companyId);
    }

    public List<Employee> getAllEmployeeByLkEmployeeId(int lkEmployeeId) {
        return repository.findEmployeesByEmpLkId(lkEmployeeId);
    }

    public List<Employee> getAllEmployeeByLkEmployeeAndCompanyId(int lkEmployeeId, int companyId) {
        return repository.findEmployeesByEmpLkIdAndCompanyId(lkEmployeeId, companyId);
    }

    public List<Employee> getAllActiveEmployeeByLkEmployeeAndCompanyId(int lkEmployeeId, int companyId) {
        return repository.findEmployeesByEmpLkIdAndCompanyIdAndEmpEndDateIsNull(lkEmployeeId, companyId);
    }

    public Employee checkExistenceEmployeeInCompany(Employee employee, int companyId) {
        return repository.findEmployeeByIdAndCompanyId(employee.getId(), companyId);
    }

    public Employee getEmployeeById(int employeeId) {
        return repository.findEmployeeById(employeeId);
    }

    public Employee getEmployeeByEmpCode(String employeeCode) {
        return repository.findEmployeeByEmpCode(employeeCode);
    }

    public Employee getEmployeeByIdAndEmpLk(int employeeId, int lkEmployeeId) {
        return repository.findEmployeeByIdAndEmpLkId(employeeId, lkEmployeeId);
    }

    public int getCountByCompanyIdAndIsActive(int company_id) {
        return repository.findCountByCompanyIdAndIsActive(company_id);
    }

}