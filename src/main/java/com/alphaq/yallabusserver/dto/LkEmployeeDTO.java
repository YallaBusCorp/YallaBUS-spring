package com.alphaq.yallabusserver.dto;

import java.util.Objects;
import java.util.Set;

public class LkEmployeeDTO {
    private Integer id;
    private String lkName;
    private Set<EmployeeDTO> employees;

    public LkEmployeeDTO() {
    }

    public LkEmployeeDTO(Integer id, String lkName, Set<EmployeeDTO> employees) {
        this.id = id;
        this.lkName = lkName;
        this.employees = employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLkName(String lkName) {
        this.lkName = lkName;
    }

    public void setEmployees(Set<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public String getLkName() {
        return lkName;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LkEmployeeDTO entity = (LkEmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lkName, entity.lkName) &&
                Objects.equals(this.employees, entity.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lkName, employees);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lkName = " + lkName + ", " +
                "employees = " + employees + ")";
    }
}
