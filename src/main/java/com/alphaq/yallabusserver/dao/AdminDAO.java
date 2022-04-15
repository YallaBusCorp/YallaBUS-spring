package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.Admin;
import com.alphaq.yallabusserver.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDAO {

    @Autowired
    private AdminRepository repository;

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(admins::add);
        return admins;
    }

    public Admin getAdminById(int adminId) {
        return repository.findAdminById(adminId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}