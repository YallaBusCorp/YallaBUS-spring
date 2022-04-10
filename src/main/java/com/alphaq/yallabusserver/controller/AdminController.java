package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;
}
