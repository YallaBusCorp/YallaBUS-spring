package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    Salary findSalaryById(int salaryId);

    List<Salary> findSalariesByEmp_CompanyId(int companyId);


}