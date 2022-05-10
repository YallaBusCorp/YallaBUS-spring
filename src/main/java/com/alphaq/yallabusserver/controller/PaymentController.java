package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.PaymentDTO;
import com.alphaq.yallabusserver.entity.Payment;
import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import com.alphaq.yallabusserver.service.PaymentService;
import com.alphaq.yallabusserver.service.StudentService;
import com.alphaq.yallabusserver.service.SubscriptionPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubscriptionPriceService subscriptionPriceService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @RequestMapping(value = "/get-all-cash", method = RequestMethod.GET)
    public List<Payment> getAllCashPayments() {
        return paymentService.getAllPaymentsByPaymentMethodType("C");
    }

    @RequestMapping(value = "/get-all-online", method = RequestMethod.GET)
    public List<Payment> getAllOnlinePayments() {
        return paymentService.getAllPaymentsByPaymentMethodType("O");
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Payment> getAllPaymentsByCompanyId(@RequestParam("id") int companyId) {
        return paymentService.getAllPaymentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/get-cash", method = RequestMethod.GET)
    public List<Payment> getAllCashPaymentsByCompanyId(@RequestParam("id") int companyId) {
        return paymentService.getAllPaymentsByCompanyIdAndPaymentMethodType(companyId,"C");
    }

    @RequestMapping(value = "/company/get-online", method = RequestMethod.GET)
    public List<Payment> getAllOnlinePaymentsByCompanyId(@RequestParam("id") int companyId) {
        return paymentService.getAllPaymentsByCompanyIdAndPaymentMethodType(companyId,"O");
    }

    @RequestMapping(value = "/student/get-all", method = RequestMethod.GET)
    public List<Payment> getAllPaymentsByStdId(@RequestParam("id") int stdId) {
        return paymentService.getPaymentsByStdId(stdId);
    }

    @RequestMapping(value = "/student/get-cash", method = RequestMethod.GET)
    public List<Payment> getAllCashPaymentsByStdId(@RequestParam("id") int stdId) {
        return paymentService.getAllPaymentsByStdIdAndPaymentMethodType(stdId,"C");
    }

    @RequestMapping(value = "/student/get-online", method = RequestMethod.GET)
    public List<Payment> getAllOnlinePaymentsByStdId(@RequestParam("id") int stdId) {
        return paymentService.getAllPaymentsByStdIdAndPaymentMethodType(stdId,"O");
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Payment getPaymentById(@RequestParam("id") int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping("/save-payment")
    public Payment save(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        Student student = null;
        if (paymentDTO.getStd().getEndSubscriptionDate() != null && paymentDTO.getStd().getId() != null) {
            student = studentService.getStudentById(paymentDTO.getStd().getId());
            student.setIsSubscribed(true);
            student.setIsActive(true);
            payment.setPaymentMethodType("C");
            student.setEndSubscriptionDate(paymentDTO.getStd().getEndSubscriptionDate());
        } else if (paymentDTO.getStd().getEndSubscriptionDate() == null && paymentDTO.getStd().getStdUid() != null) {
            student = studentService.getStudentByStdUid(paymentDTO.getStd().getStdUid());
            student.setIsSubscribed(true);
            student.setIsActive(true);
            payment.setPaymentMethodType("O");
            payment.setPaymentCode(paymentDTO.getPaymentCode());
            student.setEndSubscriptionDate(LocalDate.now().plusDays(30));
        }
        student = studentService.save(student);
        boolean flag = student.getIsSubscribed() ? true : false;
        if (flag) {
            SubscriptionPrice subscriptionPrice = subscriptionPriceService.getCurrentSubscriptionPriceInCompany(student.getCompany().getId());
            payment.setStd(student);
            payment.setPaymentStartDate(student.getEndSubscriptionDate().minusDays(30));
            payment.setPaymentEndDate(student.getEndSubscriptionDate());
            payment.setPaymentPrice(subscriptionPrice.getSubscriptionPrice());
            payment = paymentService.save(payment);
        }
        return payment;
    }


}