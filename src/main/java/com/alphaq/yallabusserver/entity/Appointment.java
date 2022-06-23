package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonManagedReference()
    @JsonIncludeProperties(value = {"id"})
    @Fetch(FetchMode.JOIN)
    private Company company;

    @Column(name = "appointment_start_time", nullable = false)
    private LocalTime appointmentStartTime;

    @Column(name = "appointment_type", nullable = false, length = 2)
    private String appointmentType;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @OneToMany(mappedBy = "appointment")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<TxBooking> txBookings = new LinkedHashSet<>();

    public Set<TxBooking> getTxBookings() {
        return txBookings;
    }

    public void setTxBookings(Set<TxBooking> txBookings) {
        this.txBookings = txBookings;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
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
        return "Appointment{" +
                "id=" + id +
                ", company=" + company +
                ", appointmentStartTime=" + appointmentStartTime +
                ", appointmentType='" + appointmentType + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}