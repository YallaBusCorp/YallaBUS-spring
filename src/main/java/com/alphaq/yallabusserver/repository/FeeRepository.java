package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Fee;
import com.alphaq.yallabusserver.entity.TxBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {

    Fee findFeeById(int feeId);

    List<Fee> findFeesByBus_Id(int busId);

    List<Fee> findFeesByBus_IdAndIsApprovedEquals(int busId, Boolean c);

    List<Fee> findFeesByBus_CompanyId(int companyId);

    List<Fee> findFeesByBus_CompanyIdAndIsApprovedEquals(int companyId, Boolean c);

    List<Fee> findFeesByBus_CompanyIdAndFeesLkId(int companyId, int lkFeeId);

    List<Fee> findFeesByBus_CompanyIdAndFeesLkIdAndIsApprovedEquals(int companyId, int lkFeeId, Boolean c);
    List<Fee> findFeesByFessDateBetween(LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime);
}