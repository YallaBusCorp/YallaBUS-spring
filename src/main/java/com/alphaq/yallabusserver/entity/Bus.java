package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bus", indexes = {
        @Index(name = "Bus_bus_code_uk", columnList = "bus_uid", unique = true),
        @Index(name = "Bus_phone_uk", columnList = "phone", unique = true)
})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id", nullable = false)
    private Integer id;

    @Column(name = "bus_uid", nullable = false)
    private String busUid;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonManagedReference()
    @JsonIncludeProperties(value = {"id"})
    private Company company;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @OneToMany(mappedBy = "bus")
    @JsonBackReference
    private Set<Fee> fees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bus")
    @JsonBackReference
    private Set<TxBus> txBuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bus")
    @JsonBackReference
    private Set<TxBooking> txBookings = new LinkedHashSet<>();

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Fee> getFees() {
        return fees;
    }

    public void setFees(Set<Fee> fees) {
        this.fees = fees;
    }

    public Set<TxBus> getTxBuses() {
        return txBuses;
    }

    public void setTxBuses(Set<TxBus> txBuses) {
        this.txBuses = txBuses;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getBusLicenceExpirationDateAlarm() {
        return busLicenceExpirationDateAlarm;
    }

    public void setBusLicenceExpirationDateAlarm(LocalDate busLicenceExpirationDateAlarm) {
        this.busLicenceExpirationDateAlarm = busLicenceExpirationDateAlarm;
    }

    public LocalDate getBusLicenceExpirationDate() {
        return busLicenceExpirationDate;
    }

    public void setBusLicenceExpirationDate(LocalDate busLicenceExpirationDate) {
        this.busLicenceExpirationDate = busLicenceExpirationDate;
    }

    public String getBusLicenceNumber() {
        return busLicenceNumber;
    }

    public void setBusLicenceNumber(String busLicenceNumber) {
        this.busLicenceNumber = busLicenceNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusUid() {
        return busUid;
    }

    public void setBusUid(String busUid) {
        this.busUid = busUid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}