package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "driver_info", indexes = {
        @Index(name = "Driver_Info_licence_number_uk", columnList = "driver_licence_number", unique = true),
        @Index(name = "emp_id", columnList = "emp_id", unique = true)
})
public class DriverInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_info_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    @JsonManagedReference()
    private Employee emp;

    @Column(name = "driver_licence_number", nullable = false)
    private String driverLicenceNumber;

    @Column(name = "driver_licence_expiration_date", nullable = false)
    private LocalDate driverLicenceExpirationDate;

    @Column(name = "driver_licence_expiration_date_alarm", nullable = false)
    private LocalDate driverLicenceExpirationDateAlarm;

    public LocalDate getDriverLicenceExpirationDateAlarm() {
        return driverLicenceExpirationDateAlarm;
    }

    public void setDriverLicenceExpirationDateAlarm(LocalDate driverLicenceExpirationDateAlarm) {
        this.driverLicenceExpirationDateAlarm = driverLicenceExpirationDateAlarm;
    }

    public LocalDate getDriverLicenceExpirationDate() {
        return driverLicenceExpirationDate;
    }

    public void setDriverLicenceExpirationDate(LocalDate driverLicenceExpirationDate) {
        this.driverLicenceExpirationDate = driverLicenceExpirationDate;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DriverInfo{" +
                "id=" + id +
                ", emp=" + emp +
                ", driverLicenceNumber='" + driverLicenceNumber + '\'' +
                ", driverLicenceExpirationDate=" + driverLicenceExpirationDate +
                ", driverLicenceExpirationDateAlarm=" + driverLicenceExpirationDateAlarm +
                '}';
    }
}