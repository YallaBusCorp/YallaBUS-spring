package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.TxBookingDTO;
import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.time.temporal.ChronoUnit;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/txBooking")
public class TxBookingController {

    @Autowired
    private TxBookingService txBookingService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MapPointService mapPointService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    BusService busService;
    @Autowired
    StudentService studentService;
    @Autowired
    TxBusService txBusService;

    @GetMapping
    public List<TxBooking> getAllTxBookings() {
        return txBookingService.getAllTxBookings();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<TxBooking> getAllTxBookingsByCompanyId(@RequestParam("id") int companyId) {
        return txBookingService.getAllTxBookingsByCompanyId(companyId);
    }

    @RequestMapping(value = "/student/get-all", method = RequestMethod.GET)
    public List<TxBooking> getAllTxBookingsByStudentId(@RequestParam("id") int stdId) {
        return txBookingService.getAllTxBookingsByStudentId(stdId);
    }

    @RequestMapping(value = "/student/get-all-scanned", method = RequestMethod.GET)
    public List<TxBooking> getAllScannedTxBookingsByStudentId(@RequestParam("id") int stdId) {
        return txBookingService.getAllTxBookingsByStudentIdAndIsScanned(stdId, true);
    }

    @RequestMapping(value = "/student/get-all-not-scanned", method = RequestMethod.GET)
    public List<TxBooking> getAllNotScannedTxBookingsByStudentId(@RequestParam("id") int stdId) {
        return txBookingService.getAllTxBookingsByStudentIdAndIsScanned(stdId, false);
    }

    @RequestMapping(value = "/company/appointment/get-all-not-assigned", method = RequestMethod.GET)
    public List<TxBooking> getAllNotAssignedTxBookingsByCompanyIdAndAppointmentId(@RequestParam("companyId") int companyId, @RequestParam("appointmentId") int appointmentId) {
        return txBookingService.getAllTxBookingsByCompanyIdAndAppointmentId(companyId, appointmentId);
    }

    @RequestMapping(value = "/company/get-all-not-assigned", method = RequestMethod.GET)
    public List<TxBooking> getAllNotAssignedTxBookingsByCompanyId(@RequestParam("id") int companyId) {

        List<TxBooking> txBookings = new ArrayList<>();
        List<Appointment> appointments = appointmentService.getAllActiveAppointmentsByCompanyId(companyId);

        for (Appointment appointment : appointments) {
            LocalTime now = LocalTime.now();
            long hours = ChronoUnit.HOURS.between(now, appointment.getAppointmentStartTime());
            if (hours <= 3 && hours >= 0) {
                txBookings.addAll(txBookingService.getAllTxBookingsByCompanyIdAndAppointmentId(companyId, appointment.getId()));
            }
        }

        return txBookings;
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public TxBooking getTxBookingById(@RequestParam("id") int txBookingId) {
        return txBookingService.getTxBookingById(txBookingId);
    }

    @RequestMapping(value = "company/get-by-id", method = RequestMethod.GET)
    public TxBooking getTxBookingByIdAndCompanyId(@RequestParam("txBookingId") int txBookingId, @RequestParam("companyId") int companyId) {
        return txBookingService.getTxBookingByIdAndCompanyId(txBookingId, companyId);
    }

    @RequestMapping(value = "/get-current-by-stdUid", method = RequestMethod.GET)
    public TxBooking getCurrentTxBookingByStudentUid(@RequestParam("uId") String stdUid) {
        return txBookingService.getCurrentTxBookingByStudentUid(stdUid);
    }


    @PostMapping("/save-txBooking")
    public TxBooking save(@RequestBody TxBookingDTO txBookingDTO) {
        TxBooking txBooking = new TxBooking();
        MapPoint pickupPoint = mapPointService.getMapPointById(txBookingDTO.getPickupPoint().getId());
        MapPoint dropoffPoint = mapPointService.getMapPointById(txBookingDTO.getDropoffPoint().getId());
        Appointment appointment = appointmentService.getAppointmentById(txBookingDTO.getAppointment().getId());
        Student student = studentService.getStudentById(txBookingDTO.getStd().getId());

        txBooking.setQrCode(txBookingDTO.getQrCode());
        txBooking.setPickupPoint(pickupPoint);
        txBooking.setDropoffPoint(dropoffPoint);
        txBooking.setAppointment(appointment);
        txBooking.setStd(student);
        return txBookingService.save(txBooking);
    }

    @PutMapping("/assign")
    public List<TxBooking> assign(@RequestBody List<TxBookingDTO> txBookingDTOS) {
        List<TxBooking> txBookings = new ArrayList<>();
        TxBooking txBooking;
        Employee employee;
        Bus bus;
        for (TxBookingDTO txBookingDTO : txBookingDTOS) {
            txBooking = txBookingService.getTxBookingById(txBookingDTO.getId());
            employee = employeeService.getEmployeeById(txBookingDTO.getEmp().getId());
            bus = busService.getBusById(txBookingDTO.getBus().getId());
            txBooking.setEmp(employee);
            txBooking.setBus(bus);
            txBookings.add(txBooking);
        }
        return txBookingService.saveList(txBookings);
    }

    @RequestMapping(value = "/scan-qrCode", method = RequestMethod.GET)
    public String scanQrCode(@RequestParam("qrCode") String qrCode, @RequestParam("busId") int busId) {
        String result = "";

        TxBooking txBooking = txBookingService.getTxBookingByQrCode(qrCode);
        if (txBooking == null)
            result = "Invalid QR Code";
        else if (txBooking.getIsScanned())
            result = "QR Code is Already Scanned";
        else if (txBooking.getBus().getId() != busId)
            result = "It is Not Your Booked Ride";
        else if (txBooking.getBus().getId() == busId) {
            result = "Valid QR Code";
            txBooking.setIsScanned(true);
            txBookingService.save(txBooking);
        }

        return result;
    }
}