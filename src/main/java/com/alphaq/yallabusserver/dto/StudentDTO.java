package com.alphaq.yallabusserver.dto;


import java.time.LocalDate;

public class StudentDTO {
    private Integer id;
    private String code;
    private String stdName;
    private String stdPhone;
    private LkTownDTO town;
    private LkUniversityDTO university;
    private CompanyDTO company;
    private LocalDate endSubscriptionDate;
    private Boolean isSubscribed;
    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
    }

    public LkTownDTO getTown() {
        return town;
    }

    public void setTown(LkTownDTO town) {
        this.town = town;
    }

    public LkUniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(LkUniversityDTO university) {
        this.university = university;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public LocalDate getEndSubscriptionDate() {
        return endSubscriptionDate;
    }

    public void setEndSubscriptionDate(LocalDate endSubscriptionDate) {
        this.endSubscriptionDate = endSubscriptionDate;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public Boolean getSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", stdName='" + stdName + '\'' +
                ", stdPhone='" + stdPhone + '\'' +
                ", town=" + town +
                ", university=" + university +
                ", company=" + company +
                ", endSubscriptionDate=" + endSubscriptionDate +
                ", isSubscribed=" + isSubscribed +
                ", isActive=" + isActive +
                '}';
    }
}
