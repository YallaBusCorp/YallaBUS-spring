package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tx_booking", indexes = {
        @Index(name = "TX_Booking_QR_code_uk", columnList = "QR_code", unique = true)
})
public class TxBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tx_booking_id", nullable = false)
    private Integer id;

    @Column(name = "QR_code", nullable = false)
    private String qrCode;

    @Column(name = "is_scanned", nullable = true)
    private Boolean isScanned = false;

    @Column(name = "booking_data", nullable = false)
    @CreationTimestamp
    private LocalDateTime bookingData;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "emp_id", nullable = true)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Employee emp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pickup_point_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private MapPoint pickupPoint;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dropoff_point_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private MapPoint dropoffPoint;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointment_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "bus_id", nullable = true)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "std_id", nullable = false)
    @JsonManagedReference()
    @Fetch(FetchMode.JOIN)
    private Student std;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Boolean getIsScanned() {
        return isScanned;
    }

    public void setIsScanned(Boolean isScanned) {
        this.isScanned = isScanned;
    }

    public LocalDateTime getBookingData() {
        return bookingData;
    }

    public void setBookingData(LocalDateTime bookingData) {
        this.bookingData = bookingData;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public MapPoint getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(MapPoint pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public MapPoint getDropoffPoint() {
        return dropoffPoint;
    }

    public void setDropoffPoint(MapPoint dropoffPoint) {
        this.dropoffPoint = dropoffPoint;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }

}