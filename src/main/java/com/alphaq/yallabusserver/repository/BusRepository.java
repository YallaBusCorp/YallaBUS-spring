package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    Bus findBusById(int busId);
    Bus findBusByIdAndCompanyId(int busId, int companyId);
    List<Bus> findBusesByCompanyId(int companyId);
    List<Bus> findBusesByCompanyIdAndIsActiveTrue(int companyId);
    List<Bus> findBusesByBusLicenceExpirationDateAlarmBeforeAndIsActiveTrueAndCompanyId(LocalDate localDate,int companyId);
}
