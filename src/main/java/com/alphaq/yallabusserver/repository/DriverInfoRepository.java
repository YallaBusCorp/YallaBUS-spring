package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.DriverInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverInfoRepository extends JpaRepository<DriverInfo, Integer> {
    DriverInfo findDriverInfoById(int driverInfoId);
}