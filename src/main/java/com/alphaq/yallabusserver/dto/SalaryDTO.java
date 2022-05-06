package com.alphaq.yallabusserver.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SalaryDTO {
    private Integer id;
    private EmployeeDTO emp;
    private Integer empSalary;
    private LocalDate salaryDate;
    private Boolean isReceived;

    public SalaryDTO() {
    }

    public SalaryDTO(Integer id, EmployeeDTO emp, Integer empSalary, LocalDate salaryDate, Boolean isReceived) {
        this.id = id;
        this.emp = emp;
        this.empSalary = empSalary;
        this.salaryDate = salaryDate;
        this.isReceived = isReceived;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public void setSalaryDate(LocalDate salaryDate) {
        this.salaryDate = salaryDate;
    }

    public void setReceived(Boolean received) {
        isReceived = received;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public LocalDate getSalaryDate() {
        return salaryDate;
    }

    public Boolean getIsReceived() {
        return isReceived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryDTO entity = (SalaryDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.emp, entity.emp) &&
                Objects.equals(this.empSalary, entity.empSalary) &&
                Objects.equals(this.salaryDate, entity.salaryDate) &&
                Objects.equals(this.isReceived, entity.isReceived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emp, empSalary, salaryDate, isReceived);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "emp = " + emp + ", " +
                "empSalary = " + empSalary + ", " +
                "salaryDate = " + salaryDate + ", " +
                "isReceived = " + isReceived + ")";
    }
}
