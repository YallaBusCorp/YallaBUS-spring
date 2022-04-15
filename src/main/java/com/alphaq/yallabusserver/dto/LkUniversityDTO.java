package com.alphaq.yallabusserver.dto;

import java.util.Objects;
import java.util.Set;

public class LkUniversityDTO {
    private Integer id;
    private String universityName;
    private CompanyDTO company;
    private Set<StudentDTO> students;
    private Boolean isActive;

    public LkUniversityDTO() {
    }

    public LkUniversityDTO(Integer id, String universityName, CompanyDTO company, Set<StudentDTO> students, Boolean isActive) {
        this.id = id;
        this.universityName = universityName;
        this.company = company;
        this.students = students;
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void setStudents(Set<StudentDTO> students) {
        this.students = students;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getId() {
        return id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public Set<StudentDTO> getStudents() {
        return students;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LkUniversityDTO entity = (LkUniversityDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.universityName, entity.universityName) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.students, entity.students) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, universityName, company, students, isActive);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "universityName = " + universityName + ", " +
                "company = " + company + ", " +
                "students = " + students + ", " +
                "isActive = " + isActive + ")";
    }
}
