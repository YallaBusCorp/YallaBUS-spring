package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "map_point", indexes = {
        @Index(name = "Map_Point_location_uk", columnList = "longitude, latitude, company_id", unique = true),
        @Index(name = "Map_Point_title_uk", columnList = "map_point_title_en, map_point_title_ar, company_id", unique = true)
})
public class MapPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_point_id", nullable = false)
    private Integer id;

    @Column(name = "map_point_title_en ", nullable = false)
    private String mapPointTitleEn;

    @Column(name = "map_point_title_ar ", nullable = false)
    private String mapPointTitleAr;

    @Column(name = "map_point_type", nullable = false)
    private Character mapPointType;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Company company;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMapPointTitleEn() {
        return mapPointTitleEn;
    }

    public void setMapPointTitleEn(String mapPointTitleEn) {
        this.mapPointTitleEn = mapPointTitleEn;
    }

    public String getMapPointTitleAr() {
        return mapPointTitleAr;
    }

    public void setMapPointTitleAr(String mapPointTitle) {
        this.mapPointTitleAr = mapPointTitle;
    }

    public Character getMapPointType() {
        return mapPointType;
    }

    public void setMapPointType(Character mapPointType) {
        this.mapPointType = mapPointType;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}