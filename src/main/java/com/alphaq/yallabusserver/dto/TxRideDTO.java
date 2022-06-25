package com.alphaq.yallabusserver.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TxRideDTO{
    private Integer id;
    private LocalDate rideData;
    private String rideStatus;
    private AppointmentDTO appointment;
    private BusDTO bus;
    private EmployeeDTO emp;

    public TxRideDTO() {
    }

    public TxRideDTO(Integer id, LocalDate rideData, String rideStatus, AppointmentDTO appointment) {
        this.id = id;
        this.rideData = rideData;
        this.rideStatus = rideStatus;
        this.appointment = appointment;
    }

    public TxRideDTO(Integer id, LocalDate rideData, String rideStatus, AppointmentDTO appointment, BusDTO bus, EmployeeDTO emp) {
        this.id = id;
        this.rideData = rideData;
        this.rideStatus = rideStatus;
        this.appointment = appointment;
        this.bus = bus;
        this.emp = emp;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getRideData() {
        return rideData;
    }

    public String getRideStatus() {
        return rideStatus;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public BusDTO getBus() {
        return bus;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRideData(LocalDate rideData) {
        this.rideData = rideData;
    }

    public void setRideStatus(String rideStatus) {
        this.rideStatus = rideStatus;
    }

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxRideDTO entity = (TxRideDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.rideData, entity.rideData) &&
                Objects.equals(this.rideStatus, entity.rideStatus) &&
                Objects.equals(this.appointment, entity.appointment) &&
                Objects.equals(this.bus, entity.bus) &&
                Objects.equals(this.emp, entity.emp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rideData, rideStatus, appointment, bus, emp);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "rideData = " + rideData + ", " +
                "rideStatus = " + rideStatus + ", " +
                "appointment = " + appointment + ", " +
                "bus = " + bus + ", " +
                "emp = " + emp + ")";
    }
}
