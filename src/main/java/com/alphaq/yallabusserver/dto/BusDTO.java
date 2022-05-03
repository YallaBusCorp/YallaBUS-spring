package com.alphaq.yallabusserver.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class BusDTO {
    private Integer id;
    private String busCode;
    private String phone;
    private String model;
    private Integer capacity;
    private String busLicenceNumber;
    private LocalDate busLicenceExpirationDate;
    private LocalDate busLicenceExpirationDateAlarm;
    private CompanyDTO company;
    private Boolean isActive;

    public BusDTO() {
    }

    public BusDTO(Integer id, String busCode, String phone, String model, Integer capacity, String busLicenceNumber, LocalDate busLicenceExpirationDate, LocalDate busLicenceExpirationDateAlarm, CompanyDTO company, Boolean isActive) {
        this.id = id;
        this.busCode = busCode;
        this.phone = phone;
        this.model = model;
        this.capacity = capacity;
        this.busLicenceNumber = busLicenceNumber;
        this.busLicenceExpirationDate = busLicenceExpirationDate;
        this.busLicenceExpirationDateAlarm = busLicenceExpirationDateAlarm;
        this.company = company;
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setBusLicenceNumber(String busLicenceNumber) {
        this.busLicenceNumber = busLicenceNumber;
    }

    public void setBusLicenceExpirationDate(LocalDate busLicenceExpirationDate) {
        this.busLicenceExpirationDate = busLicenceExpirationDate;
    }

    public void setBusLicenceExpirationDateAlarm(LocalDate busLicenceExpirationDateAlarm) {
        this.busLicenceExpirationDateAlarm = busLicenceExpirationDateAlarm;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getId() {
        return id;
    }

    public String getBusCode() {
        return busCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getModel() {
        return model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getBusLicenceNumber() {
        return busLicenceNumber;
    }

    public LocalDate getBusLicenceExpirationDate() {
        return busLicenceExpirationDate;
    }

    public LocalDate getBusLicenceExpirationDateAlarm() {
        return busLicenceExpirationDateAlarm;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusDTO entity = (BusDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.busCode, entity.busCode) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.model, entity.model) &&
                Objects.equals(this.capacity, entity.capacity) &&
                Objects.equals(this.busLicenceNumber, entity.busLicenceNumber) &&
                Objects.equals(this.busLicenceExpirationDate, entity.busLicenceExpirationDate) &&
                Objects.equals(this.busLicenceExpirationDateAlarm, entity.busLicenceExpirationDateAlarm) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, busCode, phone, model, capacity, busLicenceNumber, busLicenceExpirationDate, busLicenceExpirationDateAlarm, company, isActive);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "busCode = " + busCode + ", " +
                "phone = " + phone + ", " +
                "model = " + model + ", " +
                "capacity = " + capacity + ", " +
                "busLicenceNumber = " + busLicenceNumber + ", " +
                "busLicenceExpirationDate = " + busLicenceExpirationDate + ", " +
                "busLicenceExpirationDateAlarm = " + busLicenceExpirationDateAlarm + ", " +
                "company = " + company + ", " +
                "isActive = " + isActive + ")";
    }
}
