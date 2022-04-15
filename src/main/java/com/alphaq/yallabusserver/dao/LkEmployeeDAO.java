package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.LkEmployee;
import com.alphaq.yallabusserver.repository.LkEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LkEmployeeDAO {

    @Autowired
    private LkEmployeeRepository repository;

    public LkEmployee save(LkEmployee lkEmployee) {
        return repository.save(lkEmployee);
    }

    public List<LkEmployee> getAllLkEmployees() {
        List<LkEmployee> lkEmployees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(lkEmployees::add);
        return lkEmployees;
    }

    public LkEmployee getLkEmployeeById(int lkEmployeeId) {
        return repository.findLkEmployeeById(lkEmployeeId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}