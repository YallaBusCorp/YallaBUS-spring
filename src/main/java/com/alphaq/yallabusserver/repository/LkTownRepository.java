package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkTown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LkTownRepository extends JpaRepository<LkTown,Integer> {
    LkTown findLKTownById(int townId);
    LkTown findLKTownByIdAndCompanyId(int townId,int companyId);
    List<LkTown> findLkTownsByCompanyId(int companyId);
    List<LkTown> findLkTownsByCompanyIdAndIsActive(int companyId,boolean isActive);
}
