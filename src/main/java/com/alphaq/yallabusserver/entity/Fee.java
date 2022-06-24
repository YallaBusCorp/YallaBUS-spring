package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fees")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fees_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonManagedReference()
    private Bus bus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fees_lk_id", nullable = false)
    @JsonManagedReference()
    private LKFee feesLk;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "fess_date")
    @CreationTimestamp
    private LocalDateTime fessDate;

    @Column(name = "is_approved", nullable = true)
    private Boolean isApproved;

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

    public LocalDateTime getFessDate() {
        return fessDate;
    }

    public void setFessDate(LocalDateTime fessDate) {
        this.fessDate = fessDate;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

}