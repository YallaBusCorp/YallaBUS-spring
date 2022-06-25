package com.alphaq.yallabusserver.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class TxBookingDTO {
    private Integer id;
    private Instant bookingData;
    private Boolean isScanned;
    private String qrCode;
    private AppointmentDTO appointment;
    private BusDTO bus;
    private MapPointDTO dropoffPoint;
    private EmployeeDTO emp;
    private MapPointDTO pickupPoint;
    private StudentDTO std;
    private TxRideDTO txRide;

    public TxBookingDTO() {
    }

    public TxBookingDTO(Integer id, Instant bookingData, Boolean isScanned, String qrCode, AppointmentDTO appointment, BusDTO bus, MapPointDTO dropoffPoint, EmployeeDTO emp, MapPointDTO pickupPoint, StudentDTO std, TxRideDTO txRide) {
        this.id = id;
        this.bookingData = bookingData;
        this.isScanned = isScanned;
        this.qrCode = qrCode;
        this.appointment = appointment;
        this.bus = bus;
        this.dropoffPoint = dropoffPoint;
        this.emp = emp;
        this.pickupPoint = pickupPoint;
        this.std = std;
        this.txRide = txRide;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookingData(Instant bookingData) {
        this.bookingData = bookingData;
    }

    public void setScanned(Boolean scanned) {
        isScanned = scanned;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }

    public void setDropoffPoint(MapPointDTO dropoffPoint) {
        this.dropoffPoint = dropoffPoint;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    public void setPickupPoint(MapPointDTO pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public void setStd(StudentDTO std) {
        this.std = std;
    }

    public void setTxRide(TxRideDTO txRide) {
        this.txRide = txRide;
    }

    public Integer getId() {
        return id;
    }

    public Instant getBookingData() {
        return bookingData;
    }

    public Boolean getIsScanned() {
        return isScanned;
    }

    public String getQrCode() {
        return qrCode;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public BusDTO getBus() {
        return bus;
    }

    public MapPointDTO getDropoffPoint() {
        return dropoffPoint;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public MapPointDTO getPickupPoint() {
        return pickupPoint;
    }

    public StudentDTO getStd() {
        return std;
    }

    public TxRideDTO getTxRide() {
        return txRide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxBookingDTO entity = (TxBookingDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.bookingData, entity.bookingData) &&
                Objects.equals(this.isScanned, entity.isScanned) &&
                Objects.equals(this.qrCode, entity.qrCode) &&
                Objects.equals(this.appointment, entity.appointment) &&
                Objects.equals(this.bus, entity.bus) &&
                Objects.equals(this.dropoffPoint, entity.dropoffPoint) &&
                Objects.equals(this.emp, entity.emp) &&
                Objects.equals(this.pickupPoint, entity.pickupPoint) &&
                Objects.equals(this.std, entity.std) &&
                Objects.equals(this.txRide, entity.txRide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingData, isScanned, qrCode, appointment, bus, dropoffPoint, emp, pickupPoint, std, txRide);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "bookingData = " + bookingData + ", " +
                "isScanned = " + isScanned + ", " +
                "qrCode = " + qrCode + ", " +
                "appointment = " + appointment + ", " +
                "bus = " + bus + ", " +
                "dropoffPoint = " + dropoffPoint + ", " +
                "emp = " + emp + ", " +
                "pickupPoint = " + pickupPoint + ", " +
                "std = " + std + ", " +
                "txRide = " + txRide + ")";
    }
}
