package com.alphaq.yallabusserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "lk_fees", indexes = {
        @Index(name = "LK_fees_name_uk", columnList = "LK_name_ar, LK_name_en", unique = true)
})
public class LKFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LK_id", nullable = false)
    private Integer id;

    @Column(name = "LK_name_ar", nullable = false)
    private String lkNameAr;

    @Column(name = "LK_name_en", nullable = false)
    private String lkNameEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLkNameAr() {
        return lkNameAr;
    }

    public void setLkNameAr(String lkNameAr) {
        this.lkNameAr = lkNameAr;
    }

    public String getLkNameEn() {
        return lkNameEn;
    }

    public void setLkNameEn(String lkNameEn) {
        this.lkNameEn = lkNameEn;
    }

}