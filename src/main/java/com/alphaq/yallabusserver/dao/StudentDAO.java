package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDAO {
    @Autowired
    private StudentRepository repository;

    public Student save(Student student){
        return repository.save(student);
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(students::add);
        return students;
    }

    public Optional<Student> getStudentById(Student student){
        return repository.findById(student.getId());
    }

    public int getCount(){
        return (int) repository.count();
    }


}
