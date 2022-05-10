package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findPaymentById(int paymentId);

    //List<Payment> findPaymentByIdAndStd_CompanyId(int paymentId, int companyId);
    List<Payment> findPaymentsByStd_CompanyId(int companyId);

    List<Payment> findPaymentsByStdId(int stdId);

}