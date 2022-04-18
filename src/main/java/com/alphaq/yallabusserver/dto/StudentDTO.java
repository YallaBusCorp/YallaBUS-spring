package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class StudentDTO {
    private Integer id;
    private String stdUid;
    private String stdName;
    private String stdPhone;
    private LkTownDTO town;
    private LkUniversityDTO university;
    private CompanyDTO company;
    private LocalDate endSubscriptionDate;
    private Boolean isSubscribed;
    private Boolean isActive;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String stdUid, String stdName, String stdPhone, LkTownDTO town, LkUniversityDTO university, CompanyDTO company, LocalDate endSubscriptionDate, Boolean isSubscribed, Boolean isActive) {
        this.id = id;
        this.stdUid = stdUid;
        this.stdName = stdName;
        this.stdPhone = stdPhone;
        this.town = town;
        this.university = university;
        this.company = company;
        this.endSubscriptionDate = endSubscriptionDate;
        this.isSubscribed = isSubscribed;
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStdUid(String stdUid) {
        this.stdUid = stdUid;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
    }

    public void setTown(LkTownDTO town) {
        this.town = town;
    }

    public void setUniversity(LkUniversityDTO university) {
        this.university = university;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void setEndSubscriptionDate(LocalDate endSubscriptionDate) {
        this.endSubscriptionDate = endSubscriptionDate;
    }

    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Integer getId() {
        return id;
    }

    public String getStdUid() {
        return stdUid;
    }

    public String getStdName() {
        return stdName;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public LkTownDTO getTown() {
        return town;
    }

    public LkUniversityDTO getUniversity() {
        return university;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public LocalDate getEndSubscriptionDate() {
        return endSubscriptionDate;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO entity = (StudentDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.stdUid, entity.stdUid) &&
                Objects.equals(this.stdName, entity.stdName) &&
                Objects.equals(this.stdPhone, entity.stdPhone) &&
                Objects.equals(this.town, entity.town) &&
                Objects.equals(this.university, entity.university) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.endSubscriptionDate, entity.endSubscriptionDate) &&
                Objects.equals(this.isSubscribed, entity.isSubscribed) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stdUid, stdName, stdPhone, town, university, company, endSubscriptionDate, isSubscribed, isActive);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "stdUid = " + stdUid + ", " +
                "stdName = " + stdName + ", " +
                "stdPhone = " + stdPhone + ", " +
                "town = " + town + ", " +
                "university = " + university + ", " +
                "company = " + company + ", " +
                "endSubscriptionDate = " + endSubscriptionDate + ", " +
                "isSubscribed = " + isSubscribed + ", " +
                "isActive = " + isActive + ")";
    }
}
