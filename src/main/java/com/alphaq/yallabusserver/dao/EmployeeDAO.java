package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDAO {

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

    public List<Employee> getEmployeesByCompanyId(int companyId) {
        return repository.findEmployeesByCompanyId(companyId);
    }

    public Employee checkExistenceEmployeeInCompany(Employee employee, int companyId) {
        return repository.findEmployeeByIdAndCompanyId(employee.getId(), companyId);
    }

    public Employee getEmployeeById(int employeeId) {
        return repository.findEmployeeById(employeeId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}