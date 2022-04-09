package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
