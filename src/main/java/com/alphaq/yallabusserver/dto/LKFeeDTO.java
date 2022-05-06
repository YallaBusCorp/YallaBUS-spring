package com.alphaq.yallabusserver.dto;

import java.io.Serializable;
import java.util.Objects;

public class LKFeeDTO {
    private Integer id;
    private String lkNameAr;
    private String lkNameEn;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLkNameAr(String lkNameAr) {
        this.lkNameAr = lkNameAr;
    }

    public void setLkNameEn(String lkNameEn) {
        this.lkNameEn = lkNameEn;
    }

    public LKFeeDTO(Integer id, String lkNameAr, String lkNameEn) {
        this.id = id;
        this.lkNameAr = lkNameAr;
        this.lkNameEn = lkNameEn;
    }

    public Integer getId() {
        return id;
    }

    public String getLkNameAr() {
        return lkNameAr;
    }

    public String getLkNameEn() {
        return lkNameEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LKFeeDTO entity = (LKFeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lkNameAr, entity.lkNameAr) &&
                Objects.equals(this.lkNameEn, entity.lkNameEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lkNameAr, lkNameEn);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lkNameAr = " + lkNameAr + ", " +
                "lkNameEn = " + lkNameEn + ")";
    }
}
