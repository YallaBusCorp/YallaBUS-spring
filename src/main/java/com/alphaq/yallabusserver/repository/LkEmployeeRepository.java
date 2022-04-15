package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.LkEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LkEmployeeRepository extends JpaRepository<LkEmployee, Integer> {

    LkEmployee findLkEmployeeById(int lkEmployeeId);

}