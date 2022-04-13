package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findCompanyById (int companyId);
}
