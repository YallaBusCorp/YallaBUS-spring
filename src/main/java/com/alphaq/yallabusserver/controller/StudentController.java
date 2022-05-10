package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.*;
import com.alphaq.yallabusserver.dto.StudentDTO;
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

    @Autowired
    private SubscriptionPriceService subscriptionPriceService;

    @Autowired
    private PaymentService paymentService;


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

        student = studentService.save(student);

        if (student.getEndSubscriptionDate() != null && student.getId() != null) {
            SubscriptionPrice subscriptionPrice = subscriptionPriceService.getCurrentSubscriptionPriceInCompany(student.getCompany().getId());
            Payment payment = new Payment();

            payment.setStd(student);
            payment.setPaymentStartDate(student.getEndSubscriptionDate().minusDays(30));
            payment.setPaymentEndDate(student.getEndSubscriptionDate());
            payment.setPaymentPrice(subscriptionPrice.getSubscriptionPrice());
            paymentService.save(payment);
        }

        return student;
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
    public Boolean subscribe(@RequestBody StudentDTO studentDTO) {
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

        if (flag) {
            SubscriptionPrice subscriptionPrice = subscriptionPriceService.getCurrentSubscriptionPriceInCompany(result.getCompany().getId());
            Payment payment = new Payment();

            payment.setStd(result);
            payment.setPaymentStartDate(result.getEndSubscriptionDate().minusDays(30));
            payment.setPaymentEndDate(result.getEndSubscriptionDate());
            payment.setPaymentPrice(subscriptionPrice.getSubscriptionPrice());
            paymentService.save(payment);
        }

        return flag;
    }
}
