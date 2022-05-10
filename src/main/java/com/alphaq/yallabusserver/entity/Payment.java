package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment", indexes = {
        @Index(name = "Payment_code_uk", columnList = "payment_code", unique = true)
})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "std_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Student std;

    @Column(name = "payment_start_date", nullable = false)
    private LocalDate paymentStartDate;

    @Column(name = "payment_end_date", nullable = false)
    private LocalDate paymentEndDate;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "payment_price", nullable = false)
    private Integer paymentPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }

    public LocalDate getPaymentStartDate() {
        return paymentStartDate;
    }

    public void setPaymentStartDate(LocalDate paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public LocalDate getPaymentEndDate() {
        return paymentEndDate;
    }

    public void setPaymentEndDate(LocalDate paymentEndDate) {
        this.paymentEndDate = paymentEndDate;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Integer getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Integer paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

}