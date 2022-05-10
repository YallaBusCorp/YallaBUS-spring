package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findPaymentById(int paymentId);
    List<Payment> findPaymentsByStd_CompanyId(int companyId);
    List<Payment> findPaymentsByStdId(int stdId);
    List<Payment> findPaymentsByStd_StdUid(String stdUid);
    List<Payment> findPaymentsByPaymentMethodType(String type);
    List<Payment> findPaymentsByStd_CompanyIdAndPaymentMethodType(int companyId,String type);
    List<Payment> findPaymentsByStdIdAndPaymentMethodType(int stdId,String type);
    List<Payment> findPaymentsByStd_StdUidAndPaymentMethodType(String stdUid,String type);

}