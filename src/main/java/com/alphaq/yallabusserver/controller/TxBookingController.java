package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.TxBookingDTO;
import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<TxBooking> getAllTxBookings() {
        return txBookingService.getAllTxBookings();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<TxBooking> getAllTxBookingsByCompanyId(@RequestParam("id") int companyId) {
        return txBookingService.getAllTxBookingsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/appointment/get-all-not-assigned", method = RequestMethod.GET)
    public List<TxBooking> getAllTxBookingsByCompanyIdAndAppointmentId(@RequestParam("companyId") int companyId, @RequestParam("appointmentId") int appointmentId) {
        return txBookingService.getAllTxBookingsByCompanyIdAndAppointmentId(companyId, appointmentId);
    }


    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public TxBooking getTxBookingById(@RequestParam("id") int txBookingId) {
        return txBookingService.getTxBookingById(txBookingId);
    }

    @RequestMapping(value = "company/get-by-id", method = RequestMethod.GET)
    public TxBooking getTxBookingByIdAndCompanyId(@RequestParam("txBookingId") int txBookingId, @RequestParam("companyId") int companyId) {
        return txBookingService.getTxBookingByIdAndCompanyId(txBookingId, companyId);
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


}