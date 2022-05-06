package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.LKFee;
import com.alphaq.yallabusserver.repository.LKFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LKFeeService {

    @Autowired
    private LKFeeRepository repository;

    public LKFee save(LKFee lKFee) {
        return repository.save(lKFee);
    }

    public void delete(LKFee lKFee) {
        repository.delete(lKFee);
    }

    public List<LKFee> getAllLKFees() {
        List<LKFee> lKFees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(lKFees::add);
        return lKFees;
    }

    public LKFee getLKFeeById(int lKFeeId) {
        return repository.findLKFeeById(lKFeeId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}