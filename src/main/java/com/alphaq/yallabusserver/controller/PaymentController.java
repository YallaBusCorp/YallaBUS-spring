package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.PaymentDTO;
import com.alphaq.yallabusserver.entity.Payment;
import com.alphaq.yallabusserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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

    @RequestMapping(value = "/get-by-Stdid", method = RequestMethod.GET)
    public Payment getPaymentByStdId(@RequestParam("id") int stdId) {
        return paymentService.getPaymentByStdId(stdId);
    }

    @PostMapping("/save-payment")
    public Payment save(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = new Payment();

//        Company company = companyService.getCompanyById(paymentDTO.getCompany().getId());
//        payment.setCompany(company);
        return paymentService.save(payment);
    }


}