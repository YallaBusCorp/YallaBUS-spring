package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.DriverInfo;
import com.alphaq.yallabusserver.repository.DriverInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverInfoService {

    @Autowired
    private DriverInfoRepository repository;

    public DriverInfo save(DriverInfo driverInfo) {
        return repository.save(driverInfo);
    }

    public List<DriverInfo> getAllActiveDriverInfosByCompanyId(int companyId)
    {
     return repository.findDriverInfosByEmp_CompanyIdAndEmp_EmpEndDate(companyId,null);
    }

    public List<DriverInfo> getAllDriverInfos() {
        List<DriverInfo> driverInfos = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(driverInfos::add);
        return driverInfos;
    }

    public DriverInfo getDriverInfoById(int driverInfoId) {
        return repository.findDriverInfoById(driverInfoId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}