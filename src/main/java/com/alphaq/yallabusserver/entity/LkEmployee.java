package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lk_employee", indexes = {
        @Index(name = "LK_employee_name_uk", columnList = "LK_name", unique = true)
})
public class LkEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LK_id", nullable = false)
    private Integer id;

    @Column(name = "LK_name", nullable = false)
    private String lkName;

    @OneToMany(mappedBy = "empLk")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<Employee> employees = new LinkedHashSet<>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getLkName() {
        return lkName;
    }

    public void setLkName(String lkName) {
        this.lkName = lkName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LkEmployee{" +
                "id=" + id +
                ", lkName='" + lkName + '\'' +
                '}';
    }
}