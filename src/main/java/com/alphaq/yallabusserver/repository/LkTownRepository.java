package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkTown;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LkTownRepository extends CrudRepository<LkTown,Integer> {
}
