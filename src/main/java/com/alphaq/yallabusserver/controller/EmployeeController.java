package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;
}
