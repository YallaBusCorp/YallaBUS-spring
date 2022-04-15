package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lk_university", indexes = {
        @Index(name = "LK_University_name_uk", columnList = "university_name, company_id", unique = true)
})
public class LkUniversity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id", nullable = false)
    private Integer id;

    @Column(name = "university_name", nullable = false)
    private String universityName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonManagedReference()
    @JoinColumn(name = "company_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Company company;

    @OneToMany(mappedBy = "university")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<Student> students = new LinkedHashSet<>();

    @Column(name = "is_Active",columnDefinition = "bit(1) DEFAULT 1")
    private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LkUniversity{" +
                "id=" + id +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}