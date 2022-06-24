package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    @JsonManagedReference()
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@JsonIdentityReference(alwaysAsId = true)
    private Company company;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "emp_lk_id", nullable = false)
    @JsonManagedReference()
    private LkEmployee empLk;

    @Column(name = "emp_start_date")
    private LocalDate empStartDate;

    @Column(name = "emp_end_date")
    private LocalDate empEndDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emp")
    @JsonBackReference
    private Admin admin;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emp")
    @JsonBackReference
    private DriverInfo driverInfo;

    @OneToMany(mappedBy = "emp")
    @JsonBackReference
    private Set<TxBus> txBuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "emp")
    @JsonBackReference
    private Set<Salary> salaries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "emp")
    @JsonBackReference
    private Set<TxBooking> txBookings = new LinkedHashSet<>();

    public Set<TxBooking> getTxBookings() {
        return txBookings;
    }

    public void setTxBookings(Set<TxBooking> txBookings) {
        this.txBookings = txBookings;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public Set<TxBus> getTxBuses() {
        return txBuses;
    }

    public void setTxBuses(Set<TxBus> txBuses) {
        this.txBuses = txBuses;
    }

    public DriverInfo getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(DriverInfo driverInfo) {
        this.driverInfo = driverInfo;
    }

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

    public LkEmployee getEmpLk() {
        return empLk;
    }

    public void setEmpLk(LkEmployee empLk) {
        this.empLk = empLk;
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