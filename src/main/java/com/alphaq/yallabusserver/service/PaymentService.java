package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Payment;
import com.alphaq.yallabusserver.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(payments::add);
        return payments;
    }

    public List<Payment> getAllPaymentsByCompanyId(int companyId) {
        return repository.findPaymentsByStd_CompanyId(companyId);
    }

    public List<Payment> getAllPaymentsByPaymentMethodType(String type){
        return repository.findPaymentsByPaymentMethodType(type);
    }

    public List<Payment> getAllPaymentsByCompanyIdAndPaymentMethodType(int companyId,String type){
        return repository.findPaymentsByStd_CompanyIdAndPaymentMethodType(companyId,type);
    }

    public List<Payment> getAllPaymentsByStdIdAndPaymentMethodType(int stdId,String type){
        return repository.findPaymentsByStdIdAndPaymentMethodType(stdId,type);
    }

    public List<Payment> getPaymentsByStdId(int stdId) {
        return repository.findPaymentsByStdId(stdId);
    }



    public Payment getPaymentById(int paymentId) {
        return repository.findPaymentById(paymentId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}