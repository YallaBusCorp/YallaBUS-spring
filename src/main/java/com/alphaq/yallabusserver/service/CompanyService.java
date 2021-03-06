package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public Company save(Company company) {
        return repository.save(company);
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(companies::add);
        return companies;
    }

    public Company getCompanyById(int companyId){
        return repository.findCompanyById(companyId);
    }

    public long getCount(){
        return repository.count();
    }

}
