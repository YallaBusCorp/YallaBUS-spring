package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Admin;
import com.alphaq.yallabusserver.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

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

    public List<Admin> getAllActiveAdminsByCompanyId(int companyId) {
        return repository.findAdminsByEmp_CompanyIdAndEmp_EmpEndDate(companyId,null);
    }

    public Admin getAdminById(int adminId) {
        return repository.findAdminById(adminId);
    }

    public Admin getActiveAdminByUsernameAndPassword(String username,String password){
        return repository.findAdminByUsernameAndPasswordAndEmp_EmpEndDate(username,password,null);
    }

    public int getCount() {
        return (int) repository.count();
    }

}