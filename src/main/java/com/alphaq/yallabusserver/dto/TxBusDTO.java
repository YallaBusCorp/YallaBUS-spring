package com.alphaq.yallabusserver.dto;


import java.util.Objects;
import java.time.LocalDateTime;

public class TxBusDTO {
    private Integer id;
    private EmployeeDTO emp;
    private BusDTO bus;
    private LocalDateTime loginDate;

    public TxBusDTO() {
    }

    public TxBusDTO(Integer id, EmployeeDTO emp, BusDTO bus, LocalDateTime loginDate) {
        this.id = id;
        this.emp = emp;
        this.bus = bus;
        this.loginDate = loginDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public BusDTO getBus() {
        return bus;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxBusDTO entity = (TxBusDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.emp, entity.emp) &&
                Objects.equals(this.bus, entity.bus) &&
                Objects.equals(this.loginDate, entity.loginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emp, bus, loginDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "emp = " + emp + ", " +
                "bus = " + bus + ", " +
                "loginDate = " + loginDate + ")";
    }
}
