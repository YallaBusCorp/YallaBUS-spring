package com.alphaq.yallabusserver.dto;

import java.util.Objects;
import java.util.Set;

public class LkTownDTO {
    private Integer id;
    private String townName;
    private CompanyDTO company;
    private Set<StudentDTO> students;
    private Boolean isActive;

    public LkTownDTO() {
    }

    public LkTownDTO(Integer id, String townName, CompanyDTO company, Set<StudentDTO> students, Boolean isActive) {
        this.id = id;
        this.townName = townName;
        this.company = company;
        this.students = students;
        this.isActive = isActive;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTownName(String townName) {
        this.townName = townName;
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

    public String getTownName() {
        return townName;
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
        LkTownDTO entity = (LkTownDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.townName, entity.townName) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.students, entity.students) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, townName, company, students, isActive);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "townName = " + townName + ", " +
                "company = " + company + ", " +
                "students = " + students + ", " +
                "isActive = " + isActive + ")";
    }
}
