package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fees")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fees_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fees_lk_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private LKFee feesLk;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "fess_date")
    private LocalDate fessDate;

    @Column(name = "is_approved", nullable = false)
    private Character isApproved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public LKFee getFeesLk() {
        return feesLk;
    }

    public void setFeesLk(LKFee feesLk) {
        this.feesLk = feesLk;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LocalDate getFessDate() {
        return fessDate;
    }

    public void setFessDate(LocalDate fessDate) {
        this.fessDate = fessDate;
    }

    public Character getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Character isApproved) {
        this.isApproved = isApproved;
    }

}