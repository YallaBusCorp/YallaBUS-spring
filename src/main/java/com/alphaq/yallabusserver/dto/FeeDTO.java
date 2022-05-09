package com.alphaq.yallabusserver.dto;

import java.time.LocalDate;
import java.util.Objects;

public class FeeDTO {
    private Integer id;
    private BusDTO bus;
    private LKFeeDTO feesLk;
    private Integer price;
    private byte[] image;
    private LocalDate fessDate;
    private Boolean isApproved;

    public FeeDTO() {
    }

    public FeeDTO(Integer id, BusDTO bus, LKFeeDTO feesLk, Integer price, byte[] image, LocalDate fessDate, Boolean isApproved) {
        this.id = id;
        this.bus = bus;
        this.feesLk = feesLk;
        this.price = price;
        this.image = image;
        this.fessDate = fessDate;
        this.isApproved = isApproved;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }

    public void setFeesLk(LKFeeDTO feesLk) {
        this.feesLk = feesLk;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setFessDate(LocalDate fessDate) {
        this.fessDate = fessDate;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Integer getId() {
        return id;
    }

    public BusDTO getBus() {
        return bus;
    }

    public LKFeeDTO getFeesLk() {
        return feesLk;
    }

    public Integer getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public LocalDate getFessDate() {
        return fessDate;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeeDTO entity = (FeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.bus, entity.bus) &&
                Objects.equals(this.feesLk, entity.feesLk) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.fessDate, entity.fessDate) &&
                Objects.equals(this.isApproved, entity.isApproved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bus, feesLk, price, image, fessDate, isApproved);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "bus = " + bus + ", " +
                "feesLk = " + feesLk + ", " +
                "price = " + price + ", " +
                "image = " + image + ", " +
                "fessDate = " + fessDate + ", " +
                "isApproved = " + isApproved + ")";
    }
}
