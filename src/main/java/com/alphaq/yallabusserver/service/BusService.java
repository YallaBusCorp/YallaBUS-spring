package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Bus;
import com.alphaq.yallabusserver.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository repository;

    public Bus save(Bus bus) {
        return repository.save(bus);
    }

    public List<Bus> getAllBuss() {
        List<Bus> buss = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(buss::add);
        return buss;
    }

    public List<Bus> getAllBussByCompanyId(int companyId) {
        return repository.findBussByCompanyId(companyId);
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