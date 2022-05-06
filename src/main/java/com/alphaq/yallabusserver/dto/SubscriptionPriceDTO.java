package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class SubscriptionPriceDTO {
    private Integer id;
    private Integer subscriptionPrice;
    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionEndDate;
    private CompanyDTO company;

    public SubscriptionPriceDTO() {
    }

    public SubscriptionPriceDTO(Integer id, Integer subscriptionPrice, LocalDate subscriptionStartDate, LocalDate subscriptionEndDate, CompanyDTO company) {
        this.id = id;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
        this.company = company;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubscriptionPrice(Integer subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public LocalDate getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionPriceDTO entity = (SubscriptionPriceDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.subscriptionPrice, entity.subscriptionPrice) &&
                Objects.equals(this.subscriptionStartDate, entity.subscriptionStartDate) &&
                Objects.equals(this.subscriptionEndDate, entity.subscriptionEndDate) &&
                Objects.equals(this.company, entity.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscriptionPrice, subscriptionStartDate, subscriptionEndDate, company);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "subscriptionPrice = " + subscriptionPrice + ", " +
                "subscriptionStartDate = " + subscriptionStartDate + ", " +
                "subscriptionEndDate = " + subscriptionEndDate + ", " +
                "company = " + company + ")";
    }
}
