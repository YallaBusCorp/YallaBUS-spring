package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "std_id", nullable = false)
    @JsonManagedReference()
    private Student std;

    @Column(name = "payment_start_date", nullable = false)
    private LocalDate paymentStartDate;

    @Column(name = "payment_end_date", nullable = false)
    private LocalDate paymentEndDate;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "payment_price", nullable = false)
    private Integer paymentPrice;

    @Column(name = "payment_method_type", nullable = false, length = 1)
    private String paymentMethodType;

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", std=" + std +
                ", paymentStartDate=" + paymentStartDate +
                ", paymentEndDate=" + paymentEndDate +
                ", paymentCode='" + paymentCode + '\'' +
                ", paymentPrice=" + paymentPrice +
                ", paymentMethodType='" + paymentMethodType + '\'' +
                '}';
    }
}