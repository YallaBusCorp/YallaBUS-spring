package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.StudentDAO;
import com.alphaq.yallabusserver.dto.StudentDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.entity.LkUniversity;
import com.alphaq.yallabusserver.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/student/get-by-id", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id") int studentId){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
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
        student.setCode(studentDTO.getCode());
        return studentDAO.save(student);
    }

}
