package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeDTO {
    private Integer id;
    private LkEmployeeDTO empLk;
    private String empCode;
    private String empName;
    private String empPhone;
    private String empNationalId;
    private Integer empSalary;
    private LocalDate empStartDate;
    private LocalDate empEndDate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, LkEmployeeDTO empLk, String empCode, String empName, String empPhone, String empNationalId, Integer empSalary, LocalDate empStartDate, LocalDate empEndDate) {
        this.id = id;
        this.empLk = empLk;
        this.empCode = empCode;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empNationalId = empNationalId;
        this.empSalary = empSalary;
        this.empStartDate = empStartDate;
        this.empEndDate = empEndDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LkEmployeeDTO getEmpLk() {
        return empLk;
    }

    public void setEmpLk(LkEmployeeDTO empLk) {
        this.empLk = empLk;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpNationalId() {
        return empNationalId;
    }

    public void setEmpNationalId(String empNationalId) {
        this.empNationalId = empNationalId;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public LocalDate getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(LocalDate empStartDate) {
        this.empStartDate = empStartDate;
    }

    public LocalDate getEmpEndDate() {
        return empEndDate;
    }

    public void setEmpEndDate(LocalDate empEndDate) {
        this.empEndDate = empEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.empLk, entity.empLk) &&
                Objects.equals(this.empCode, entity.empCode) &&
                Objects.equals(this.empName, entity.empName) &&
                Objects.equals(this.empPhone, entity.empPhone) &&
                Objects.equals(this.empNationalId, entity.empNationalId) &&
                Objects.equals(this.empSalary, entity.empSalary) &&
                Objects.equals(this.empStartDate, entity.empStartDate) &&
                Objects.equals(this.empEndDate, entity.empEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empLk, empCode, empName, empPhone, empNationalId, empSalary, empStartDate, empEndDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "empLk = " + empLk + ", " +
                "empCode = " + empCode + ", " +
                "empName = " + empName + ", " +
                "empPhone = " + empPhone + ", " +
                "empNationalId = " + empNationalId + ", " +
                "empSalary = " + empSalary + ", " +
                "empStartDate = " + empStartDate + ", " +
                "empEndDate = " + empEndDate + ")";
    }
}
