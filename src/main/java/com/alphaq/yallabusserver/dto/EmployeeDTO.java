package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeDTO {
    private Integer id;
    private CompanyDTO company;
    private String empCode;
    private String empName;
    private String empPhone;
    private String empNationalId;
    private Integer empSalary;
    private LkEmployeeDTO empLk;
    private LocalDate empStartDate;
    private LocalDate empEndDate;
    private AdminDTO admin;
    private DriverInfoDTO driverInfo;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, CompanyDTO company, String empCode, String empName, String empPhone, String empNationalId, Integer empSalary, LkEmployeeDTO empLk, LocalDate empStartDate, LocalDate empEndDate, AdminDTO admin, DriverInfoDTO driverInfo) {
        this.id = id;
        this.company = company;
        this.empCode = empCode;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empNationalId = empNationalId;
        this.empSalary = empSalary;
        this.empLk = empLk;
        this.empStartDate = empStartDate;
        this.empEndDate = empEndDate;
        this.admin = admin;
        this.driverInfo = driverInfo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
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

    public void setEmpLk(LkEmployeeDTO empLk) {
        this.empLk = empLk;
    }

    public void setEmpStartDate(LocalDate empStartDate) {
        this.empStartDate = empStartDate;
    }

    public void setEmpEndDate(LocalDate empEndDate) {
        this.empEndDate = empEndDate;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public void setDriverInfo(DriverInfoDTO driverInfo) {
        this.driverInfo = driverInfo;
    }

    public Integer getId() {
        return id;
    }

    public CompanyDTO getCompany() {
        return company;
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

    public LkEmployeeDTO getEmpLk() {
        return empLk;
    }

    public LocalDate getEmpStartDate() {
        return empStartDate;
    }

    public LocalDate getEmpEndDate() {
        return empEndDate;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public DriverInfoDTO getDriverInfo() {
        return driverInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.empCode, entity.empCode) &&
                Objects.equals(this.empName, entity.empName) &&
                Objects.equals(this.empPhone, entity.empPhone) &&
                Objects.equals(this.empNationalId, entity.empNationalId) &&
                Objects.equals(this.empSalary, entity.empSalary) &&
                Objects.equals(this.empLk, entity.empLk) &&
                Objects.equals(this.empStartDate, entity.empStartDate) &&
                Objects.equals(this.empEndDate, entity.empEndDate) &&
                Objects.equals(this.admin, entity.admin) &&
                Objects.equals(this.driverInfo, entity.driverInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, empCode, empName, empPhone, empNationalId, empSalary, empLk, empStartDate, empEndDate, admin, driverInfo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "company = " + company + ", " +
                "empCode = " + empCode + ", " +
                "empName = " + empName + ", " +
                "empPhone = " + empPhone + ", " +
                "empNationalId = " + empNationalId + ", " +
                "empSalary = " + empSalary + ", " +
                "empLk = " + empLk + ", " +
                "empStartDate = " + empStartDate + ", " +
                "empEndDate = " + empEndDate + ", " +
                "admin = " + admin + ", " +
                "driverInfo = " + driverInfo + ")";
    }
}
