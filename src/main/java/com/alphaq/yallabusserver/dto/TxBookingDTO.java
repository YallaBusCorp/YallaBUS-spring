package com.alphaq.yallabusserver.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class TxBookingDTO {
    private Integer id;
    private String qrCode;
    private Boolean isScanned;
    private LocalDateTime bookingData;
    private EmployeeDTO emp;
    private MapPointDTO pickupPoint;
    private MapPointDTO dropoffPoint;
    private AppointmentDTO appointment;
    private BusDTO bus;
    private StudentDTO std;

    public TxBookingDTO() {
    }

    public TxBookingDTO(Integer id, String qrCode, Boolean isScanned, LocalDateTime bookingData, EmployeeDTO emp, MapPointDTO pickupPoint, MapPointDTO dropoffPoint, AppointmentDTO appointment, BusDTO bus, StudentDTO std) {
        this.id = id;
        this.qrCode = qrCode;
        this.isScanned = isScanned;
        this.bookingData = bookingData;
        this.emp = emp;
        this.pickupPoint = pickupPoint;
        this.dropoffPoint = dropoffPoint;
        this.appointment = appointment;
        this.bus = bus;
        this.std = std;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setScanned(Boolean scanned) {
        isScanned = scanned;
    }

    public void setBookingData(LocalDateTime bookingData) {
        this.bookingData = bookingData;
    }

    public void setEmp(EmployeeDTO emp) {
        this.emp = emp;
    }

    public void setPickupPoint(MapPointDTO pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public void setDropoffPoint(MapPointDTO dropoffPoint) {
        this.dropoffPoint = dropoffPoint;
    }

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public void setBus(BusDTO bus) {
        this.bus = bus;
    }

    public void setStd(StudentDTO std) {
        this.std = std;
    }

    public Integer getId() {
        return id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public Boolean getIsScanned() {
        return isScanned;
    }

    public LocalDateTime getBookingData() {
        return bookingData;
    }

    public EmployeeDTO getEmp() {
        return emp;
    }

    public MapPointDTO getPickupPoint() {
        return pickupPoint;
    }

    public MapPointDTO getDropoffPoint() {
        return dropoffPoint;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public BusDTO getBus() {
        return bus;
    }

    public StudentDTO getStd() {
        return std;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxBookingDTO entity = (TxBookingDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.qrCode, entity.qrCode) &&
                Objects.equals(this.isScanned, entity.isScanned) &&
                Objects.equals(this.bookingData, entity.bookingData) &&
                Objects.equals(this.emp, entity.emp) &&
                Objects.equals(this.pickupPoint, entity.pickupPoint) &&
                Objects.equals(this.dropoffPoint, entity.dropoffPoint) &&
                Objects.equals(this.appointment, entity.appointment) &&
                Objects.equals(this.bus, entity.bus) &&
                Objects.equals(this.std, entity.std);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qrCode, isScanned, bookingData, emp, pickupPoint, dropoffPoint, appointment, bus, std);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "qrCode = " + qrCode + ", " +
                "isScanned = " + isScanned + ", " +
                "bookingData = " + bookingData + ", " +
                "emp = " + emp + ", " +
                "pickupPoint = " + pickupPoint + ", " +
                "dropoffPoint = " + dropoffPoint + ", " +
                "appointment = " + appointment + ", " +
                "bus = " + bus + ", " +
                "std = " + std + ")";
    }
}
