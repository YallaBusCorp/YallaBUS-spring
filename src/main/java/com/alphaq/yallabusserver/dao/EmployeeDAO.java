package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {
    @Autowired
    EmployeeRepository repository;
}
