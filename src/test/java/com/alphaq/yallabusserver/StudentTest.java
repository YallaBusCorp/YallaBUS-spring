package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentService studentService;

    //@Test
    void getCompanyStudents(){
        int companyId = 2;
        List<Student> students = studentService.getAllActiveStudentsByCompanyId(companyId);
        System.out.println(students.stream().count());
        System.out.println(students);
    }
}
