package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentsByCompanyId(int companyId);
}
