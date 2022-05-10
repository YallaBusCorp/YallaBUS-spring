package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class PaymentDTO {
    private Integer id;
    private StudentDTO std;
    private LocalDate paymentStartDate;
    private LocalDate paymentEndDate;
    private String paymentCode;
    private Integer paymentPrice;
    private String paymentMethodType;

    public PaymentDTO() {
    }

    public PaymentDTO(Integer id, StudentDTO std, LocalDate paymentStartDate, LocalDate paymentEndDate, String paymentCode, Integer paymentPrice, String paymentMethodType) {
        this.id = id;
        this.std = std;
        this.paymentStartDate = paymentStartDate;
        this.paymentEndDate = paymentEndDate;
        this.paymentCode = paymentCode;
        this.paymentPrice = paymentPrice;
        this.paymentMethodType = paymentMethodType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStd(StudentDTO std) {
        this.std = std;
    }

    public void setPaymentStartDate(LocalDate paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public void setPaymentEndDate(LocalDate paymentEndDate) {
        this.paymentEndDate = paymentEndDate;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public void setPaymentPrice(Integer paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public Integer getId() {
        return id;
    }

    public StudentDTO getStd() {
        return std;
    }

    public LocalDate getPaymentStartDate() {
        return paymentStartDate;
    }

    public LocalDate getPaymentEndDate() {
        return paymentEndDate;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public Integer getPaymentPrice() {
        return paymentPrice;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO that = (PaymentDTO) o;
        return id.equals(that.id) && std.equals(that.std) && paymentStartDate.equals(that.paymentStartDate) && paymentEndDate.equals(that.paymentEndDate) && Objects.equals(paymentCode, that.paymentCode) && paymentPrice.equals(that.paymentPrice) && paymentMethodType.equals(that.paymentMethodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, std, paymentStartDate, paymentEndDate, paymentCode, paymentPrice, paymentMethodType);
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
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
