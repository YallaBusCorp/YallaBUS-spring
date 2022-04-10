package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.LkEmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LkEmployeeController {

    @Autowired
    private LkEmployeeDAO lkEmployeeDAO;
}
