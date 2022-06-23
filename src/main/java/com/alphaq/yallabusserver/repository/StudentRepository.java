package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentsByCompanyId(int companyId);
    List<Student> findStudentsByCompanyIdAndIsActiveEquals(int companyId, boolean isActive);
    Student findStudentsById(int studentId);
    Student findStudentByStdUid(String stdUid);

    @Query("SELECT COUNT(s.id) FROM Student  s WHERE s.company.id = ?1 AND s.isActive = ?2")
    int findCountByCompanyIdAndIsActive(int company_id,Boolean is_active);
}
