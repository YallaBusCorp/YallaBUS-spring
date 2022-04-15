package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeDTO {
    private Integer id;
    private LkEmployeeDTO empLk;
    private CompanyDTO company;
    private AdminDTO admin;
    private String empCode;
    private String empName;
    private String empPhone;
    private String empNationalId;
    private Integer empSalary;
    private LocalDate empStartDate;
    private LocalDate empEndDate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, LkEmployeeDTO empLk, CompanyDTO company, AdminDTO admin, String empCode, String empName, String empPhone, String empNationalId, Integer empSalary, LocalDate empStartDate, LocalDate empEndDate) {
        this.id = id;
        this.empLk = empLk;
        this.company = company;
        this.admin = admin;
        this.empCode = empCode;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empNationalId = empNationalId;
        this.empSalary = empSalary;
        this.empStartDate = empStartDate;
        this.empEndDate = empEndDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmpLk(LkEmployeeDTO empLk) {
        this.empLk = empLk;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public void setEmpNationalId(String empNationalId) {
        this.empNationalId = empNationalId;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public void setEmpStartDate(LocalDate empStartDate) {
        this.empStartDate = empStartDate;
    }

    public void setEmpEndDate(LocalDate empEndDate) {
        this.empEndDate = empEndDate;
    }

    public Integer getId() {
        return id;
    }

    public LkEmployeeDTO getEmpLk() {
        return empLk;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public String getEmpCode() {
        return empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public String getEmpNationalId() {
        return empNationalId;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public LocalDate getEmpStartDate() {
        return empStartDate;
    }

    public LocalDate getEmpEndDate() {
        return empEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.empLk, entity.empLk) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.admin, entity.admin) &&
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
        return Objects.hash(id, empLk, company, admin, empCode, empName, empPhone, empNationalId, empSalary, empStartDate, empEndDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "empLk = " + empLk + ", " +
                "company = " + company + ", " +
                "admin = " + admin + ", " +
                "empCode = " + empCode + ", " +
                "empName = " + empName + ", " +
                "empPhone = " + empPhone + ", " +
                "empNationalId = " + empNationalId + ", " +
                "empSalary = " + empSalary + ", " +
                "empStartDate = " + empStartDate + ", " +
                "empEndDate = " + empEndDate + ")";
    }
}
