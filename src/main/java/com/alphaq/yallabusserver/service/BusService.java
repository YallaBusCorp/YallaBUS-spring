package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Bus;
import com.alphaq.yallabusserver.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository repository;

    public Bus save(Bus bus) {
        return repository.save(bus);
    }

    public List<Bus> getAllBuses() {
        List<Bus> buss = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(buss::add);
        return buss;
    }

    public List<Bus> getAllBusesByCompanyId(int companyId) {
        return repository.findBusesByCompanyId(companyId);
    }

    public List<Bus> getAllActiveBusesByCompanyId(int companyId) {
        return repository.findBusesByCompanyIdAndIsActiveTrue(companyId);

    }

    public List<Bus> getAllBusesThatLicenceEndSoonByCompanyId(int companyId) {
        return repository.findBusesByBusLicenceExpirationDateAlarmBeforeAndIsActiveTrueAndCompanyId(LocalDate.now(),companyId);
    }

    public Bus checkExistenceBusInCompany(Bus bus, int companyId) {
        return repository.findBusByIdAndCompanyId(bus.getId(), companyId);
    }

    public Bus getBusById(int busId) {
        return repository.findBusById(busId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}