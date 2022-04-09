package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDAO {
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

    public Optional<Company> getCompanyById(Company company){
        return repository.findById(company.getId());
    }

    public long getCount(){
        return repository.count();
    }

}
