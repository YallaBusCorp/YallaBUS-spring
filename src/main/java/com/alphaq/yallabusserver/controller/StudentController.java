package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.StudentDAO;
import com.alphaq.yallabusserver.dto.StudentDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.entity.LkUniversity;
import com.alphaq.yallabusserver.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/student/get-all")
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    @GetMapping("/student/get-by-id")
    public Student getStudentById(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        Optional<Student> optional = studentDAO.getStudentById(student);
        if (optional.isPresent())
            student = optional.get();
        return student;
    }

    @PostMapping("/student/save-student")
    public Student save(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        Company company = new Company();
        LkTown lkTown = new LkTown();
        LkUniversity lkUniversity = new LkUniversity();
        student.setCompany(company);
        student.setTown(lkTown);
        student.setUniversity(lkUniversity);
        int count = studentDAO.getCount();
        student.setId(++count);
        student.setStdName(studentDTO.getStdName());
        student.setStdPhone(studentDTO.getStdPhone());
        student.setEndSubscriptionDate(studentDTO.getEndSubscriptionDate());
        student.setIsSubscribed(studentDTO.getIsSubscribed());
        student.getCompany().setId(studentDTO.getCompany().getId());
        student.getTown().setId(studentDTO.getTown().getId());
        student.getUniversity().setId(studentDTO.getUniversity().getId());
        return studentDAO.save(student);
    }

}
