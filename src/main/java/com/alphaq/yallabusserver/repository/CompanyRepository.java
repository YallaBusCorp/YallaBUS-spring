package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer> {
}
