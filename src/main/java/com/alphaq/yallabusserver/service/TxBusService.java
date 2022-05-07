package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.TxBus;
import com.alphaq.yallabusserver.repository.TxBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TxBusService {

    @Autowired
    private TxBusRepository repository;

    public TxBus save(TxBus txBus) {
        return repository.save(txBus);
    }

    public List<TxBus> getAllTxBuses() {
        List<TxBus> txBuss = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(txBuss::add);
        return txBuss;
    }

    public List<TxBus> getAllTxBusesByCompanyId(int companyId) {
        return repository.findTxBusesByBus_CompanyId(companyId);
    }

    public List<TxBus> getAllTxBusesByEmployeeId(int employeeId) {
        return repository.findTxBusesByEmpId(employeeId);
    }

    public List<TxBus> getAllTxBusesByBusId(int busId) {
        return repository.findTxBusesByBusId(busId);
    }
//    public List<TxBus> getAllTxBusesByDate(LocalDateTime localDateTime) {
//        return repository.findTxBusesByLoginDateEquals(localDateTime);
//    }

    public List<TxBus> getAllTxBusesByDate(LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {
        return repository.findTxBusesByLoginDateBetween(startLocalDateTime, endLocalDateTime);
    }

//    public TxBus checkExistenceTxBusInCompany(TxBus txBus, int companyId) {
//        return repository.findTxBusByIdAndCompanyId(txBus.getId(), companyId);
//    }

    public TxBus getTxBusById(int txBusId) {
        return repository.findTxBusById(txBusId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}