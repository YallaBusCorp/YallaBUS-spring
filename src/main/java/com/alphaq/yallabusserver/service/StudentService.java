package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student save(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(students::add);
        return students;
    }

    public Student getStudentById(int studentId) {
        return repository.findStudentsById(studentId);
    }

    public Student getStudentByStdUid(String stdUid) {
        return repository.findStudentByStdUid(stdUid);
    }

    public List<Student> getAllStudentsByCompanyId(int companyId) {
        return repository.findStudentsByCompanyId(companyId);
    }

    public List<Student> getAllActiveStudentsByCompanyId(int companyId) {
        return repository.findStudentsByCompanyIdAndIsActiveEquals(companyId, true);

    }

    public int getCountByCompanyIdAndIsActive(int company_id) {
         return repository.findCountByCompanyIdAndIsActive(company_id,true);
    }
}
