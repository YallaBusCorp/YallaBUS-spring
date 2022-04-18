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

import java.time.LocalDate;
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

    @RequestMapping(value = "/get-by-uid", method = RequestMethod.GET)
    public Student getStudentByStdUid(@RequestParam("stdUid") String stdUid) {
        return studentService.getStudentByStdUid(stdUid);
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
        student.setStdUid(studentDTO.getStdUid());
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
        student.setStdUid(studentDTO.getStdUid());
        student.setIsActive(studentDTO.getIsActive());
        return studentService.save(student);
    }

    @PutMapping("/delete-student")
    public Boolean delete(@RequestParam("id") int studentId) {
        Student student = studentService.getStudentById(studentId);
        student.setIsActive(false);
        Student result = studentService.save(student);

        if (!result.getIsActive())
            return true;
        return false;
    }

    @PutMapping("/subscription")
    public Boolean subscription(@RequestBody StudentDTO studentDTO) {
        Boolean flag;
        Student student;
        if (studentDTO.getEndSubscriptionDate() != null && studentDTO.getId() != null) {
            student = studentService.getStudentById(studentDTO.getId());
            student.setIsSubscribed(true);
            student.setIsActive(true);
            student.setEndSubscriptionDate(studentDTO.getEndSubscriptionDate());
        } else if (studentDTO.getEndSubscriptionDate() == null && studentDTO.getStdUid() != null) {
            student = studentService.getStudentByStdUid(studentDTO.getStdUid());
            student.setIsSubscribed(true);
            student.setIsActive(true);
            student.setEndSubscriptionDate(LocalDate.now().plusDays(30));
        } else
            student = null;
        Student result = studentService.save(student);
        flag = result.getIsSubscribed() ? true : false;

        return flag;
    }
}
