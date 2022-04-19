package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class DriverInfoDTO {
    private Integer id;
    private EmployeeDTO emp;
    private String driverLicenceNumber;
    private LocalDate driverLicenceExpirationDate;
    private LocalDate driverLicenceExpirationDateAlarm;

    public DriverInfoDTO() {
    }

    public DriverInfoDTO(Integer id, EmployeeDTO emp, String driverLicenceNumber, LocalDate driverLicenceExpirationDate, LocalDate driverLicenceExpirationDateAlarm) {
        this.id = id;
        this.emp = emp;
        this.driverLicenceNumber = driverLicenceNumber;
        this.driverLicenceExpirationDate = driverLicenceExpirationDate;
        this.driverLicenceExpirationDateAlarm = driverLicenceExpirationDateAlarm;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public void setDriverLicenceExpirationDate(LocalDate driverLicenceExpirationDate) {
        this.driverLicenceExpirationDate = driverLicenceExpirationDate;
    }

    public void setDriverLicenceExpirationDateAlarm(LocalDate driverLicenceExpirationDateAlarm) {
        this.driverLicenceExpirationDateAlarm = driverLicenceExpirationDateAlarm;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public LocalDate getDriverLicenceExpirationDate() {
        return driverLicenceExpirationDate;
    }

    public LocalDate getDriverLicenceExpirationDateAlarm() {
        return driverLicenceExpirationDateAlarm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverInfoDTO entity = (DriverInfoDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.emp, entity.emp) &&
                Objects.equals(this.driverLicenceNumber, entity.driverLicenceNumber) &&
                Objects.equals(this.driverLicenceExpirationDate, entity.driverLicenceExpirationDate) &&
                Objects.equals(this.driverLicenceExpirationDateAlarm, entity.driverLicenceExpirationDateAlarm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emp, driverLicenceNumber, driverLicenceExpirationDate, driverLicenceExpirationDateAlarm);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "emp = " + emp + ", " +
                "driverLicenceNumber = " + driverLicenceNumber + ", " +
                "driverLicenceExpirationDate = " + driverLicenceExpirationDate + ", " +
                "driverLicenceExpirationDateAlarm = " + driverLicenceExpirationDateAlarm + ")";
    }
}
