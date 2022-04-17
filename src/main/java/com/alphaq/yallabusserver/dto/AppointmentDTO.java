package com.alphaq.yallabusserver.dto;

import java.time.LocalTime;
import java.util.Objects;

public class AppointmentDTO {
    private Integer id;
    private LocalTime appointmentStartTime;
    private String appointmentType;
    private CompanyDTO company;
    private Boolean isActive;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Integer id, LocalTime appointmentStartTime, String appointmentType, CompanyDTO company, Boolean isActive) {
        this.id = id;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentType = appointmentType;
        this.company = company;
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public String getAppointmentType() {
        return appointmentType;
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
        AppointmentDTO entity = (AppointmentDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.appointmentStartTime, entity.appointmentStartTime) &&
                Objects.equals(this.appointmentType, entity.appointmentType) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointmentStartTime, appointmentType, company, isActive);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "appointmentStartTime = " + appointmentStartTime + ", " +
                "appointmentType = " + appointmentType + ", " +
                "company = " + company + ", " +
                "isActive = " + isActive + ")";
    }
}
