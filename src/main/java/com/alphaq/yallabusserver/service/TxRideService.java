package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.TxRide;
import com.alphaq.yallabusserver.repository.TxRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TxRideService {

    @Autowired
    private TxRideRepository repository;

    public TxRide save(TxRide txRide) {
        return repository.save(txRide);
    }

    public List<TxRide> saveList (List<TxRide> txRides){
        return repository.saveAll(txRides);
    }

    public List<TxRide> getAllTxRides() {
        List<TxRide> txRides = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(txRides::add);
        return txRides;
    }

    public List<TxRide> getAllTxRidesByCompanyId(int companyId) {
        return repository.findTxRidesByAppointmentCompanyId(companyId);
    }

    public List<TxRide> getAllTxRidesByRideData(LocalDate rideData) {
        return repository.findTxRidesByRideData(rideData);
    }

    public List<TxRide> getAllTxRidesByCompanyIdAndRideData(int companyId, LocalDate rideData) {
        return repository.findTxRidesByAppointmentCompanyIdAndRideData(companyId, rideData);
    }

    public List<TxRide> getAllTxRidesByCompanyIdAndRideStatus(int companyId,String rideStatus){
        return repository.findTxRidesByAppointmentCompanyIdAndRideStatus(companyId,rideStatus);
    }

    public TxRide checkExistenceTxRideInCompany(TxRide txRide, int companyId) {
        return repository.findTxRideByIdAndAppointmentCompanyId(txRide.getId(), companyId);
    }

    public TxRide getTxRideById(int txRideId) {
        return repository.findTxRideById(txRideId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}