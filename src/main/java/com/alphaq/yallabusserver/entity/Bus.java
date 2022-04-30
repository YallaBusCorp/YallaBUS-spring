package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id", nullable = false)
    private Integer id;

    @Column(name = "bus_code", nullable = false)
    private String busCode;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "model")
    private String model;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "bus_licence_number", nullable = false)
    private String busLicenceNumber;

    @Column(name = "bus_licence_expiration_date", nullable = false)
    private LocalDate busLicenceExpirationDate;

    @Column(name = "bus_licence_expiration_date_alarm", nullable = false)
    private LocalDate busLicenceExpirationDateAlarm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Company company;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBusLicenceNumber() {
        return busLicenceNumber;
    }

    public void setBusLicenceNumber(String busLicenceNumber) {
        this.busLicenceNumber = busLicenceNumber;
    }

    public LocalDate getBusLicenceExpirationDate() {
        return busLicenceExpirationDate;
    }

    public void setBusLicenceExpirationDate(LocalDate busLicenceExpirationDate) {
        this.busLicenceExpirationDate = busLicenceExpirationDate;
    }

    public LocalDate getBusLicenceExpirationDateAlarm() {
        return busLicenceExpirationDateAlarm;
    }

    public void setBusLicenceExpirationDateAlarm(LocalDate busLicenceExpirationDateAlarm) {
        this.busLicenceExpirationDateAlarm = busLicenceExpirationDateAlarm;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}