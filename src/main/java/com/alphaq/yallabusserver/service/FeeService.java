package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Fee;
import com.alphaq.yallabusserver.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

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

    public List<Fee> getAllFeesByBusId(int busId) {
        return repository.findFeesByBus_Id(busId);
    }

    public List<Fee> getAllApprovedFeesByBusId(int busId) {
        return repository.findFeesByBus_IdAndIsApprovedEquals(busId, 'Y');
    }

    public List<Fee> getAllNotApprovedFeesByBusId(int busId) {
        return repository.findFeesByBus_IdAndIsApprovedEquals(busId, 'N');
    }

//    public Fee checkExistenceFeeInCompany(Fee fee, int companyId) {
//        return repository.findFeeByIdAndCompanyId(fee.getId(), companyId);
//    }

    public Fee getFeeById(int feeId) {
        return repository.findFeeById(feeId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}