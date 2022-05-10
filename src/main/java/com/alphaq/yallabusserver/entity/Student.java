package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "town_id")
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private LkTown town;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private LkUniversity university;

    @Column(name = "std_name", nullable = false)
    private String stdName;

    @Column(name = "std_phone", nullable = false)
    private String stdPhone;

    @Column(name = "end_subscription_date")
    private LocalDate endSubscriptionDate;

    @Column(name = "is_subscribed")
    private Boolean isSubscribed;

    @Column(name = "std_uid", nullable = false)
    private String stdUid;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @OneToMany(mappedBy = "std")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "std")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<TxBooking> txBookings = new LinkedHashSet<>();

    public Set<TxBooking> getTxBookings() {
        return txBookings;
    }

    public void setTxBookings(Set<TxBooking> txBookings) {
        this.txBookings = txBookings;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getStdUid() {
        return stdUid;
    }

    public void setStdUid(String stdUid) {
        this.stdUid = stdUid;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public LocalDate getEndSubscriptionDate() {
        return endSubscriptionDate;
    }

    public void setEndSubscriptionDate(LocalDate endSubscriptionDate) {
        this.endSubscriptionDate = endSubscriptionDate;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public LkUniversity getUniversity() {
        return university;
    }

    public void setUniversity(LkUniversity university) {
        this.university = university;
    }

    public LkTown getTown() {
        return town;
    }

    public void setTown(LkTown town) {
        this.town = town;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stdUid='" + stdUid + '\'' +
                ", stdName='" + stdName + '\'' +
                ", stdPhone='" + stdPhone + '\'' +
                ", endSubscriptionDate=" + endSubscriptionDate +
                ", isSubscribed=" + isSubscribed +
                ", isActive=" + isActive +
                '}';
    }

}