package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    Bus findBusById(int busId);

    Bus findBusByIdAndCompanyId(int busId, int companyId);

    List<Bus> findBussByCompanyId(int companyId);

}