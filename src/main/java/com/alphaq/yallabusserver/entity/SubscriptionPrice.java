package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscription_price")
public class SubscriptionPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", nullable = false)
    private Integer id;

    @Column(name = "subscription_price", nullable = false)
    private Integer subscriptionPrice;

    @Column(name = "subscription_start_date", nullable = false)
    private LocalDate subscriptionStartDate;

    @Column(name = "subscription_end_date")
    private LocalDate subscriptionEndDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference()
    @JoinColumn(name = "company_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Integer getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(Integer subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}