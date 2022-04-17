package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "appointment", indexes = {
        @Index(name = "Appointment_start_time_uk", columnList = "appointment_start_time, company_id", unique = true)
})
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false)
    private Integer id;

    @Column(name = "appointment_start_time", nullable = false)
    private LocalTime appointmentStartTime;

    @Column(name = "appointment_type", nullable = false, length = 2)
    private String appointmentType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference()
    @JoinColumn(name = "company_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Company company;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

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
                ", appointmentStartTime=" + appointmentStartTime +
                ", appointmentType='" + appointmentType + '\'' +
                ", company=" + company +
                ", isActive=" + isActive +
                '}';
    }
}