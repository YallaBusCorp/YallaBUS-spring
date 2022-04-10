package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.repository.LkEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LkEmployeeDAO {
    @Autowired
    LkEmployeeRepository repository;

}
