package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer> {
}
