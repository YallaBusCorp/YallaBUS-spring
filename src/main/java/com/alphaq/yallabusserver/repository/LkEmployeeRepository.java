package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LkEmployeeRepository extends CrudRepository<LkEmployee,Integer> {
}