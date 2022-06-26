package com.alphaq.yallabusserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "tx_booking", indexes = {
        @Index(name = "TX_Booking_QR_code_uk", columnList = "qr_code", unique = true)
})
public class TxBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tx_booking_id", nullable = false)
    private Integer id;

    @Column(name = "booking_data", nullable = true)
    @CreationTimestamp
    private LocalDateTime bookingData;

    @Column(name = "is_scanned")
    private Boolean isScanned;

    @Column(name = "qr_code", nullable = false)
    private String qrCode;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "appointment_id", nullable = false)
    @JsonManagedReference()
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "bus_id", nullable = true)
    @JsonManagedReference()
    private Bus bus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "dropoff_point_id", nullable = false)
    @JsonManagedReference()
    private MapPoint dropoffPoint;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "emp_id", nullable = true)
    @JsonManagedReference()
    private Employee emp;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pickup_point_id", nullable = false)
    @JsonManagedReference()
    private MapPoint pickupPoint;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "std_id", nullable = false)
    @JsonManagedReference()
    private Student std;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "tx_ride_id")
    @JsonManagedReference()
    private TxRide txRide;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getBookingData() {
        return bookingData;
    }

    public void setBookingData(LocalDateTime bookingData) {
        this.bookingData = bookingData;
    }

    public Boolean getIsScanned() {
        return isScanned;
    }

    public void setIsScanned(Boolean isScanned) {
        this.isScanned = isScanned;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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

    public MapPoint getDropoffPoint() {
        return dropoffPoint;
    }

    public void setDropoffPoint(MapPoint dropoffPoint) {
        this.dropoffPoint = dropoffPoint;
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

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }

    public TxRide getTxRide() {
        return txRide;
    }

    public void setTxRide(TxRide txRide) {
        this.txRide = txRide;
    }

}