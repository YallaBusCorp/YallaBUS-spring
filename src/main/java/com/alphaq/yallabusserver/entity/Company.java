package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "company", indexes = {
        @Index(name = "company_name_uk", columnList = "company_name", unique = true)
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_phone", nullable = false, length = 14)
    private String companyPhone;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "company_location", nullable = false)
    private String companyLocation;

    @Column(name = "imgURL", nullable = false)
    private String imgURL;

    @Column(name = "facebookURL", nullable = false)
    private String facebookURL;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<Student> students = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<LkTown> lkTowns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<LkUniversity> lkUniversities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<MapPoint> mapPoints = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<Bus> buses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<SubscriptionPrice> subscriptionPrices = new LinkedHashSet<>();

    public Set<SubscriptionPrice> getSubscriptionPrices() {
        return subscriptionPrices;
    }

    public void setSubscriptionPrices(Set<SubscriptionPrice> subscriptionPrices) {
        this.subscriptionPrices = subscriptionPrices;
    }

    public Set<Bus> getBuses() {
        return buses;
    }

    public void setBuses(Set<Bus> buses) {
        this.buses = buses;
    }

    public Set<MapPoint> getMapPoints() {
        return mapPoints;
    }

    public void setMapPoints(Set<MapPoint> mapPoints) {
        this.mapPoints = mapPoints;
    }

    public Set<LkUniversity> getLkUniversities() {
        return lkUniversities;
    }

    public void setLkUniversities(Set<LkUniversity> lkUniversities) {
        this.lkUniversities = lkUniversities;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<LkTown> getLkTowns() {
        return lkTowns;
    }

    public void setLkTowns(Set<LkTown> lkTowns) {
        this.lkTowns = lkTowns;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", description='" + description + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", facebookURL='" + facebookURL + '\'' +
                '}';
    }

}