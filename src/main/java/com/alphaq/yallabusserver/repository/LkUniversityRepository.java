package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkUniversity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LkUniversityRepository extends CrudRepository<LkUniversity,Integer> {
}
