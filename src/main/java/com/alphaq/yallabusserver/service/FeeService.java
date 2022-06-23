package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Fee;
import com.alphaq.yallabusserver.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository repository;

    public Fee save(Fee fee) {
        return repository.save(fee);
    }

    public List<Fee> getAllFees() {
        List<Fee> fees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(fees::add);
        return fees;
    }


    public List<Fee> getAllFeesByCompanyIdAndLkFeeId(int companyId, int lkFeeId) {
        return repository.findFeesByBus_CompanyIdAndFeesLkId(companyId, lkFeeId);
    }

    public List<Fee> getAllApprovedFeesByCompanyIdAndLkFeeId(int companyId, int lkFeeId) {
        return repository.findFeesByBus_CompanyIdAndFeesLkIdAndIsApprovedEquals(companyId, lkFeeId, true);
    }

    public List<Fee> getAllNotApprovedFeesByCompanyIdAndLkFeeId(int companyId, int lkFeeId) {
        return repository.findFeesByBus_CompanyIdAndFeesLkIdAndIsApprovedEquals(companyId, lkFeeId, false);
    }

    public List<Fee> getAllPendingFeesByCompanyIdAndLkFeeId(int companyId, int lkFeeId) {
        return repository.findFeesByBus_CompanyIdAndFeesLkIdAndIsApprovedEquals(companyId, lkFeeId, null);
    }


    public List<Fee> getAllFeesByCompanyId(int companyId) {
        return repository.findFeesByBus_CompanyId(companyId);
    }

    public List<Fee> getAllApprovedFeesByCompanyId(int companyId) {
        return repository.findFeesByBus_CompanyIdAndIsApprovedEquals(companyId, true);
    }

    public List<Fee> getAllNotApprovedFeesByCompanyId(int companyId) {
        return repository.findFeesByBus_CompanyIdAndIsApprovedEquals(companyId, false);
    }

    public List<Fee> getAllPendingFeesByCompanyId(int companyId) {
        return repository.findFeesByBus_CompanyIdAndIsApprovedEquals(companyId, null);
    }


    public List<Fee> getAllFeesByBusId(int busId) {
        return repository.findFeesByBus_Id(busId);
    }

    public List<Fee> getAllApprovedFeesByBusId(int busId) {
        return repository.findFeesByBus_IdAndIsApprovedEquals(busId, true);
    }

    public List<Fee> getAllNotApprovedFeesByBusId(int busId) {
        return repository.findFeesByBus_IdAndIsApprovedEquals(busId, false);
    }

    public List<Fee> getAllPendingFeesByBusId(int busId) {
        return repository.findFeesByBus_IdAndIsApprovedEquals(busId, null);
    }


    public List<Fee> getAllFeesByDateBetween(LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {
        return repository.findFeesByFessDateBetween(startLocalDateTime, endLocalDateTime);
    }

    public Fee getFeeById(int feeId) {
        return repository.findFeeById(feeId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}