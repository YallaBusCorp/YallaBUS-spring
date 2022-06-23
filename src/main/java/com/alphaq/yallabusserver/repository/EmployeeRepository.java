package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeById(int employeeId);
    Employee findEmployeeByEmpCode(String employeeCode);
    Employee findEmployeeByIdAndCompanyId(int employeeId, int companyId);
    Employee findEmployeeByIdAndEmpLkId(int employeeId, int lkEmployeeId);
    List<Employee> findEmployeesByCompanyId(int companyId);
    List<Employee> findEmployeesByCompanyIdAndEmpEndDateIsNull(int companyId);
    List<Employee> findEmployeesByEmpLkId(int lkEmployeeId);
    List<Employee> findEmployeesByEmpLkIdAndCompanyId(int lkEmployeeId,int companyId);
    List<Employee> findEmployeesByEmpLkIdAndCompanyIdAndEmpEndDateIsNull(int lkEmployeeId,int companyId);
    @Query("SELECT COUNT(e.id) FROM Employee  e WHERE e.company.id = ?1 AND e.empEndDate IS NULL")
    int findCountByCompanyIdAndIsActive(int company_id);
}