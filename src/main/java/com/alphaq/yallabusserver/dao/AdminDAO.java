package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {

    @Autowired
    AdminRepository repository;
}
