package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkTown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LkTownRepository extends JpaRepository<LkTown,Integer> {
    LkTown findLKTownByIdAndCompanyId(int townId,int companyId);
}
