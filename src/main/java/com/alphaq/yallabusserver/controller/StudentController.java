package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.LkTownDAO;
import com.alphaq.yallabusserver.dao.LkUniversityDAO;
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

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private LkUniversityDAO lkUniversityDAO;

    @Autowired
    private LkTownDAO lkTownDAO;

    @GetMapping("/student/get-all")
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    @RequestMapping(value = "/student/get-by-company-id", method = RequestMethod.GET)
    public List<Student> getStudentsByCompanyId(@RequestParam("id") int companyId){
        return studentDAO.getStudentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/student/get-by-id", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id") int studentId){
        return studentDAO.getStudentById(studentId);
    }

    @PostMapping("/student/save-student")
    public Student save(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        Company company = new Company();
        LkTown lkTown = new LkTown();
        LkUniversity lkUniversity = new LkUniversity();

        company.setId(studentDTO.getCompany().getId());
        Optional< Company > optionalCompany = companyDAO.getCompanyById(company);
        if (optionalCompany.isPresent())
            student.setCompany(optionalCompany.get());

        lkTown.setId(studentDTO.getTown().getId());
        Optional<LkTown> optionalLkTown = lkTownDAO.getLKTownById(lkTown);
        if(optionalLkTown.isPresent()&&lkTownDAO.getLKTownByIdAndCompanyId(optionalLkTown.get(),company.getId())!=null)
            student.setTown(optionalLkTown.get());

        lkUniversity.setId(studentDTO.getUniversity().getId());
        Optional<LkUniversity> optionalLkUniversity = lkUniversityDAO.getLkUniversityById(lkUniversity);
        if(optionalLkUniversity.isPresent()&&lkUniversityDAO.getLkUniversityByIdAndCompanyId(optionalLkUniversity.get(),company.getId())!=null)
            student.setUniversity(optionalLkUniversity.get());

        student.setStdName(studentDTO.getStdName());
        student.setStdPhone(studentDTO.getStdPhone());
        student.setEndSubscriptionDate(studentDTO.getEndSubscriptionDate());
        student.setIsSubscribed(studentDTO.getIsSubscribed());
        student.setCode(studentDTO.getCode());
        return studentDAO.save(student);
    }

}
