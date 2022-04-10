package com.alphaq.yallabusserver.dto;

import java.io.Serializable;
import java.util.Objects;

public class LkEmployeeDTO implements Serializable {
    private final Integer id;
    private final String lkName;

    public LkEmployeeDTO(Integer id, String lkName) {
        this.id = id;
        this.lkName = lkName;
    }

    public Integer getId() {
        return id;
    }

    public String getLkName() {
        return lkName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LkEmployeeDTO entity = (LkEmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lkName, entity.lkName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lkName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lkName = " + lkName + ")";
    }
}
