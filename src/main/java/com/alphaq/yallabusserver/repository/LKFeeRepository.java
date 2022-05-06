package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LKFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LKFeeRepository extends JpaRepository<LKFee, Integer> {

    LKFee findLKFeeById(int lKFeeId);

//    LKFee findLKFeeByIdAndCompanyId(int lKFeeId, int companyId);

//    List<LKFee> findLKFeesByCompanyId(int companyId);

}