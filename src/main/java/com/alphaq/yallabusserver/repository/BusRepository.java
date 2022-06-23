package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    Bus findBusById(int busId);
    Bus findBusByBusUid(String busUid);
    Bus findBusByIdAndCompanyId(int busId, int companyId);
    List<Bus> findBussByCompanyId(int companyId);
    List<Bus> findBusesByCompanyIdAndAndIsActiveEquals(int companyId,boolean isActive);
    @Query("SELECT COUNT(b.id) FROM Bus  b WHERE b.company.id = ?1 AND b.isActive = ?2")
    int findCountByCompanyIdAndIsActive(int company_id,Boolean is_active);

}