package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LkUniversityRepository extends JpaRepository<LkUniversity,Integer> {
    LkUniversity findLkUniversityByIdAndCompanyId(int universityId,int companyId);
}
