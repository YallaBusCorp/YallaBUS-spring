package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Salary;
import com.alphaq.yallabusserver.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository repository;

    public Salary save(Salary salary) {
        return repository.save(salary);
    }

    public List<Salary> getAllSalaries() {
        List<Salary> salarys = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(salarys::add);
        return salarys;
    }

    public List<Salary> getAllSalariesInCompany(int companyId) {
        return repository.findSalariesByEmp_CompanyId(companyId);
    }

    public List<Salary> getAllReceivedSalariesInCompany(int companyId){
        return repository.findSalariesByEmp_CompanyIdAndIsReceivedEquals(companyId,true);
    }
    public List<Salary> getAllNotReceivedSalariesInCompany(int companyId){
        return repository.findSalariesByEmp_CompanyIdAndIsReceivedEquals(companyId,false);
    }


    public Salary getSalaryById(int salaryId) {
        return repository.findSalaryById(salaryId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}