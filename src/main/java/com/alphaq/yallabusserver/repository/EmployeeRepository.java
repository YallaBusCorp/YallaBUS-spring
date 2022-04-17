package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeById(int employeeId);
    Employee findEmployeeByIdAndCompanyId(int employeeId, int companyId);
    List<Employee> findEmployeesByCompanyId(int companyId);
    List<Employee> findEmployeesByCompanyIdAndEmpEndDateIsNull(int companyId);

}