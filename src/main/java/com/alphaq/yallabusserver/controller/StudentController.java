package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.LkTownService;
import com.alphaq.yallabusserver.service.LkUniversityService;
import com.alphaq.yallabusserver.service.StudentService;
import com.alphaq.yallabusserver.dto.StudentDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.entity.LkUniversity;
import com.alphaq.yallabusserver.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private LkUniversityService lkUniversityService;

    @Autowired
    private LkTownService lkTownService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Student> getALLStudentsByCompanyId(@RequestParam("id") int companyId) {
        return studentService.getAllStudentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<Student> getAllActiveStudentsByCompanyId(@RequestParam("id") int companyId) {
        return studentService.getAllActiveStudentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id") int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/save-student")
    public Student save(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        Company company = companyService.getCompanyById(studentDTO.getCompany().getId());
        LkTown lkTown = lkTownService.getLKTownById(studentDTO.getTown().getId());
        LkUniversity lkUniversity = lkUniversityService.getLkUniversityById(studentDTO.getUniversity().getId());

        if (company != null)
            student.setCompany(company);

        if (lkTown != null && lkTownService.checkExistenceTownInCompany(lkTown, company.getId()) != null)
            student.setTown(lkTown);

        if (lkUniversity != null && lkUniversityService.checkExistenceUniversityInCompany(lkUniversity, company.getId()) != null)
            student.setUniversity(lkUniversity);

        student.setStdName(studentDTO.getStdName());
        student.setStdPhone(studentDTO.getStdPhone());
        student.setEndSubscriptionDate(studentDTO.getEndSubscriptionDate());
        student.setIsSubscribed(studentDTO.getIsSubscribed());
        student.setCode(studentDTO.getCode());
        student.setIsActive(true);
        return studentService.save(student);
    }

    @PutMapping("/update-student")
    public Student update(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();

        student.setId(studentDTO.getId());
        Company company = companyService.getCompanyById(studentDTO.getCompany().getId());
        LkTown lkTown = lkTownService.getLKTownById(studentDTO.getTown().getId());
        LkUniversity lkUniversity = lkUniversityService.getLkUniversityById(studentDTO.getUniversity().getId());

        if (company != null)
            student.setCompany(company);

        if (lkTown != null && lkTownService.checkExistenceTownInCompany(lkTown, company.getId()) != null)
            student.setTown(lkTown);

        if (lkUniversity != null && lkUniversityService.checkExistenceUniversityInCompany(lkUniversity, company.getId()) != null)
            student.setUniversity(lkUniversity);

        student.setStdName(studentDTO.getStdName());
        student.setStdPhone(studentDTO.getStdPhone());
        student.setEndSubscriptionDate(studentDTO.getEndSubscriptionDate());
        student.setIsSubscribed(studentDTO.getIsSubscribed());
        student.setCode(studentDTO.getCode());
        student.setIsActive(studentDTO.getIsActive());
        return studentService.save(student);
    }

    @RequestMapping(value = "/delete-student", method = RequestMethod.DELETE)
    public Student delete(@RequestParam(value = "id", required = false) int studentId) {
        Student student = studentService.getStudentById(studentId);
        student.setIsActive(false);
        return studentService.save(student);
//        student = studentService.save(student);
//        if(!student.getIsActive())
//            return true;
//        return false;
    }

}
