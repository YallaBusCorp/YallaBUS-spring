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

@CrossOrigin(origins = "https://yalla-bus.herokuapp.com/", maxAge = 3600)
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
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @RequestMapping(value = "/student/get-by-company-id", method = RequestMethod.GET)
    public List<Student> getStudentsByCompanyId(@RequestParam("id") int companyId) {
        return studentDAO.getStudentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/student/get-by-id", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id") int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    @PostMapping("/student/save-student")
    public Student save(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        Company company = companyDAO.getCompanyById(studentDTO.getCompany().getId());
        LkTown lkTown = lkTownDAO.getLKTownById(studentDTO.getTown().getId());
        LkUniversity lkUniversity = lkUniversityDAO.getLkUniversityById(studentDTO.getUniversity().getId());

        if (company != null)
            student.setCompany(company);

        if (lkTown != null && lkTownDAO.checkExistenceTownInCompany(lkTown, company.getId()) != null)
            student.setTown(lkTown);

        if (lkUniversity != null && lkUniversityDAO.checkExistenceUniversityInCompany(lkUniversity, company.getId()) != null)
            student.setUniversity(lkUniversity);

        student.setStdName(studentDTO.getStdName());
        student.setStdPhone(studentDTO.getStdPhone());
        student.setEndSubscriptionDate(studentDTO.getEndSubscriptionDate());
        student.setIsSubscribed(studentDTO.getIsSubscribed());
        student.setCode(studentDTO.getCode());
        return studentDAO.save(student);
    }

}
