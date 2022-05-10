package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dto.PaymentDTO;
import com.alphaq.yallabusserver.dto.StudentDTO;
import com.alphaq.yallabusserver.entity.Payment;
import com.alphaq.yallabusserver.entity.Student;
import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import com.alphaq.yallabusserver.service.PaymentService;
import com.alphaq.yallabusserver.service.StudentService;
import com.alphaq.yallabusserver.service.SubscriptionPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

//@SpringBootTest
public class PaymentTest {
    @Autowired
    PaymentService paymentService;
    @Autowired
    StudentService studentService;
    @Autowired
    SubscriptionPriceService subscriptionPriceService;

    //@Test
    void save() {

        //int stdId = 6;
        String stdUid = "97641616215615612aas";

        StudentDTO studentDTO = new StudentDTO();
        //Dashboard
//        studentDTO.setId(stdId);
//        studentDTO.setEndSubscriptionDate(LocalDate.now().plusDays(30));
        //mobile
        studentDTO.setStdUid(stdUid);

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setStd(studentDTO);
        //Dashboard

        //mobile
        paymentDTO.setPaymentCode("54g5fs5a448");

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
        System.out.println(payment);
    }
}
