package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tx_ride", indexes = {
        @Index(name = "ride_data", columnList = "ride_data, appointment_id, bus_id, emp_id", unique = true)
})
public class TxRide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tx_ride_id", nullable = false)
    private Integer id;

    @Column(name = "ride_data", nullable = false)
    private LocalDate rideData;

    @Column(name = "ride_status", length = 10)
    private String rideStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "appointment_id", nullable = false)
    @JsonManagedReference()
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "bus_id", nullable = true)
    @JsonManagedReference()
    private Bus bus;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "emp_id", nullable = true)
    @JsonManagedReference()
    private Employee emp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRideData() {
        return rideData;
    }

    public void setRideData(LocalDate rideData) {
        this.rideData = rideData;
    }

    public String getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(String rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

}