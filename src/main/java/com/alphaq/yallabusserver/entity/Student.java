package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student", indexes = {
        @Index(name = "Student_phone_uk", columnList = "std_phone", unique = true)
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id", nullable = false)
    private Integer id;

    @Column(name = "std_uid", nullable = true, unique = true)
    private String uid;

    @Column(name = "std_name", nullable = true)
    private String stdName;

    @Column(name = "std_phone", nullable = true)
    private String stdPhone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference()
    @JoinColumn(name = "town_id", nullable = true)
    @Fetch(FetchMode.JOIN)
    private LkTown town;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference()
    @JoinColumn(name = "university_id", nullable = true)
    @Fetch(FetchMode.JOIN)
    private LkUniversity university;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference()
    @JoinColumn(name = "company_id", nullable = true)
    @Fetch(FetchMode.JOIN)
    private Company company;

    @Column(name = "end_subscription_date", nullable = true)
    private LocalDate endSubscriptionDate;

    @Column(name = "is_subscribed", nullable = true)
    private Boolean isSubscribed = false;

    @Column(name = "is_Active", nullable = true)
    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String code) {
        this.uid = code;
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
                ", uid='" + uid + '\'' +
                ", stdName='" + stdName + '\'' +
                ", stdPhone='" + stdPhone + '\'' +
                ", endSubscriptionDate=" + endSubscriptionDate +
                ", isSubscribed=" + isSubscribed +
                ", isActive=" + isActive +
                '}';
    }
}