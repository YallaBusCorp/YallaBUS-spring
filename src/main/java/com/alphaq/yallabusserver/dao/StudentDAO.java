package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDAO {
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

    public List<Student> getStudentsByCompanyId(int companyId) {
        return repository.findStudentsByCompanyId(companyId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}
