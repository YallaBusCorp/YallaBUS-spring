package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {

    Fee findFeeById(int feeId);

    //Fee findFeeByIdAndCompanyId(int feeId, int companyId);

    List<Fee> findFeesByBus_Id(int busId);
    List<Fee> findFeesByBus_IdAndIsApprovedEquals(int busId,Character c);

}