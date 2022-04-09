package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "company", indexes = {
        @Index(name = "company_name_uk", columnList = "company_name", unique = true)
})
public class Company {
    @Id
    @Column(name = "company_id", nullable = false)
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<Student> students = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<LkTown> lkTowns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<LkUniversity> lkUniversities = new LinkedHashSet<>();

    public Set<LkUniversity> getLkUniversities() {
        return lkUniversities;
    }

    public void setLkUniversities(Set<LkUniversity> lkUniversities) {
        this.lkUniversities = lkUniversities;
    }

    public Set<LkTown> getLkTowns() {
        return lkTowns;
    }

    public void setLkTowns(Set<LkTown> lkTowns) {
        this.lkTowns = lkTowns;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}