package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LkUniversityRepository extends JpaRepository<LkUniversity,Integer> {
    LkUniversity findLkUniversityById(int universityId);
    LkUniversity findLkUniversityByIdAndCompanyId(int universityId,int companyId);
    List<LkUniversity> findLkUniversitiesByCompanyId(int companyId);
    List<LkUniversity> findLkUniversitiesByCompanyIdAndIsActiveEquals(int companyId,boolean isActive);
}
