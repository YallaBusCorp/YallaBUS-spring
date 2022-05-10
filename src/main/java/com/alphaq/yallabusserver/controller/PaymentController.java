package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.PaymentDTO;
import com.alphaq.yallabusserver.entity.Payment;
import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.service.PaymentService;
import com.alphaq.yallabusserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Payment> getAllPaymentsByCompanyId(@RequestParam("id") int companyId) {
        return paymentService.getAllPaymentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Payment getPaymentById(@RequestParam("id") int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @RequestMapping(value = "/get-by-StdId", method = RequestMethod.GET)
    public List<Payment> getPaymentsByStdId(@RequestParam("id") int stdId) {
        return paymentService.getPaymentsByStdId(stdId);
    }

    @PostMapping("/save-payment")
    public Payment save(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = new Payment();

        Student student = studentService.getStudentById(paymentDTO.getStd().getId());
        payment.setStd(student);
        payment.setPaymentStartDate(paymentDTO.getPaymentStartDate());
        payment.setPaymentEndDate(paymentDTO.getPaymentEndDate());
        payment.setPaymentCode(paymentDTO.getPaymentCode());
        payment.setPaymentPrice(paymentDTO.getPaymentPrice());
        payment.setPaymentMethodType(paymentDTO.getPaymentMethodType());
        return paymentService.save(payment);
    }


}