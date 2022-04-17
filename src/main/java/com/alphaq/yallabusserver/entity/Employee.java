package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference()
    @JoinColumn(name = "emp_lk_id")
    @Fetch(FetchMode.JOIN)
    private LkEmployee empLk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference()
    @JoinColumn(name = "company_id")
    @Fetch(FetchMode.JOIN)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emp")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Admin admin;

    @Column(name = "emp_code", nullable = false)
    private String empCode;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "emp_phone", nullable = false)
    private String empPhone;

    @Column(name = "emp_national_id", nullable = false)
    private String empNationalId;

    @Column(name = "emp_salary", nullable = false)
    private Integer empSalary;

    @Column(name = "emp_start_date")
    private LocalDate empStartDate;

    @Column(name = "emp_end_date")
    private LocalDate empEndDate;


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LocalDate getEmpEndDate() {
        return empEndDate;
    }

    public void setEmpEndDate(LocalDate empEndDate) {
        this.empEndDate = empEndDate;
    }

    public LocalDate getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(LocalDate empStartDate) {
        this.empStartDate = empStartDate;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpNationalId() {
        return empNationalId;
    }

    public void setEmpNationalId(String empNationalId) {
        this.empNationalId = empNationalId;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LkEmployee getEmpLk() {
        return empLk;
    }

    public void setEmpLk(LkEmployee empLk) {
        this.empLk = empLk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empNationalId='" + empNationalId + '\'' +
                ", empSalary=" + empSalary +
                ", empStartDate=" + empStartDate +
                ", empEndDate=" + empEndDate +
                '}';
    }
}