package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminById(int adminId);
    Admin findAdminByUsernameAndPasswordAndEmp_EmpEndDate(String username,String password, LocalDate localDate);
    List<Admin> findAdminsByEmp_CompanyIdAndEmp_EmpEndDate(int companyId, LocalDate localDate);



}