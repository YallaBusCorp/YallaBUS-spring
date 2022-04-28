package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.DriverInfo;
import com.alphaq.yallabusserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Repository
public interface DriverInfoRepository extends JpaRepository<DriverInfo, Integer> {
    DriverInfo findDriverInfoById(int driverInfoId);
    List<Employee> findDriverInfosByEmp_CompanyId(int companyId);
    Employee findDriverInfoByIdAndEmp_CompanyId(int employeeId, int companyId);
    List<DriverInfo> findDriverInfosByEmp_CompanyIdAndEmp_EmpEndDate(int companyId,LocalDate localDate);

}