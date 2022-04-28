package com.alphaq.yallabusserver.dto;

import java.util.Objects;

public class MapPointDTO {
    private Integer id;
    private String mapPointTitleEn;
    private String mapPointTitleAr;
    private Character mapPointType;
    private Double longitude;
    private Double latitude;
    private CompanyDTO company;
    private Boolean isActive;

    public MapPointDTO() {
    }

    public MapPointDTO(Integer id, String mapPointTitleEn, String mapPointTitleAr, Character mapPointType, Double longitude, Double latitude, CompanyDTO company, Boolean isActive) {
        this.id = id;
        this.mapPointTitleEn = mapPointTitleEn;
        this.mapPointTitleAr = mapPointTitleAr;
        this.mapPointType = mapPointType;
        this.longitude = longitude;
        this.latitude = latitude;
        this.company = company;
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMapPointTitleEn(String mapPointTitleEn) {
        this.mapPointTitleEn = mapPointTitleEn;
    }

    public void setMapPointTitleAr(String mapPointTitleAr) {
        this.mapPointTitleAr = mapPointTitleAr;
    }

    public void setMapPointType(Character mapPointType) {
        this.mapPointType = mapPointType;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getId() {
        return id;
    }

    public String getMapPointTitleEn() {
        return mapPointTitleEn;
    }

    public String getMapPointTitleAr() {
        return mapPointTitleAr;
    }

    public Character getMapPointType() {
        return mapPointType;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapPointDTO entity = (MapPointDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.mapPointTitleAr, entity.mapPointTitleAr) &&
                Objects.equals(this.mapPointType, entity.mapPointType) &&
                Objects.equals(this.longitude, entity.longitude) &&
                Objects.equals(this.latitude, entity.latitude) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mapPointTitleAr, mapPointType, longitude, latitude, company, isActive);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "mapPointTitleEn = " + mapPointTitleEn + ", " +
                "mapPointTitleAr = " + mapPointTitleAr + ", " +
                "mapPointType = " + mapPointType + ", " +
                "longitude = " + longitude + ", " +
                "latitude = " + latitude + ", " +
                "company = " + company + ", " +
                "isActive = " + isActive + ")";
    }
}
