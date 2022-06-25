package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.TxRideDTO;
import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/txRide")
public class TxRideController {

    @Autowired
    private TxRideService txRideService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private BusService busService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TxBookingService txBookingService;


    @GetMapping
    public List<TxRide> getAllTxRides() {
        return txRideService.getAllTxRides();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<TxRide> getAllTxRidesByCompanyId(@RequestParam("id") int companyId) {
        return txRideService.getAllTxRidesByCompanyId(companyId);
    }

    @RequestMapping(value = "/date/get-all", method = RequestMethod.GET)
    public List<TxRide> getAllTxRidesByRideDate(@RequestParam("date") String date) {
        LocalDate rideData = LocalDate.parse(date);
        return txRideService.getAllTxRidesByRideData(rideData);
    }

    @RequestMapping(value = "/company/date/get-all", method = RequestMethod.GET)
    public List<TxRide> getAllTxRidesByCompanyIdAndRideData(@RequestParam("id") int companyId, @RequestParam("date") String date) {
        LocalDate rideData = LocalDate.parse(date);
        return txRideService.getAllTxRidesByCompanyIdAndRideData(companyId, rideData);
    }

    @RequestMapping(value = "/company/status/get-all", method = RequestMethod.GET)
    public List<TxRide> getAllTxRidesByCompanyIdAndRideStatus(@RequestParam("id") int companyId, @RequestParam("status") String status) {
        return txRideService.getAllTxRidesByCompanyIdAndRideStatus(companyId, status);
    }

    @RequestMapping(value = "/company/get-all-pending", method = RequestMethod.GET)
    public List<TxRide> getAllPendingTxRidesByCompanyId(@RequestParam("id") int companyId) {
        return txRideService.getAllTxRidesByCompanyIdAndRideStatus(companyId, "pending");
    }

    @RequestMapping(value = "/company/get-all-process", method = RequestMethod.GET)
    public List<TxRide> getAllProcessTxRidesByCompanyId(@RequestParam("id") int companyId) {
        return txRideService.getAllTxRidesByCompanyIdAndRideStatus(companyId, "process");
    }

    @RequestMapping(value = "/company/get-all-complete", method = RequestMethod.GET)
    public List<TxRide> getAllCompleteTxRidesByCompanyId(@RequestParam("id") int companyId) {
        return txRideService.getAllTxRidesByCompanyIdAndRideStatus(companyId, "complete");
    }

    @RequestMapping(value = "/company/get-rides-need-to-assign", method = RequestMethod.GET)
    public List<TxRide> getAllRidesNeedToAssignByCompanyId(@RequestParam("id") int companyId) {
        return txRideService.getAllTxRidesByCompanyIdAndRideStatusEqualsAndEmpIsNullAndBusIsNull(companyId, "process");
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public TxRide getTxRideById(@RequestParam("id") int txRideId) {
        return txRideService.getTxRideById(txRideId);
    }

    @RequestMapping(value = "/get-current-by-stdUid", method = RequestMethod.GET)
    public TxRide getCurrentTxRideByStudentUid(@RequestParam("uId") String stdUid) {
        Integer txRideId = txBookingService.getCurrentTxBookingByStudentUid(stdUid).getTxRide().getId();
        return txRideService.getTxRideById(txRideId);
    }

    @RequestMapping(value = "/get-current-by-busUid", method = RequestMethod.GET)
    public TxRide getCurrentTxRideByBusUid(@RequestParam("uId") String busUid) {
        return txRideService.getTxRideByBusBusUidAndRideStatus(busUid,"process");
    }

    @PostMapping("/save-txRide")
    public TxRide save(@RequestBody TxRideDTO txRideDTO) {
        TxRide txRide = new TxRide();
        txRide.setRideData(txRideDTO.getRideData());
        txRide.setRideStatus("process");
        Appointment appointment = appointmentService.getAppointmentById(txRideDTO.getAppointment().getId());
        Bus bus = busService.getBusById(txRideDTO.getBus().getId());
        Employee employee = employeeService.getEmployeeById(txRideDTO.getEmp().getId());
        txRide.setAppointment(appointment);
        txRide.setBus(bus);
        txRide.setEmp(employee);
        return txRideService.save(txRide);
    }

    @PutMapping("/canceled")
    public TxRide canceled(@RequestParam("id") int rideId) {
        TxRide txRide = txRideService.getTxRideById(rideId);
        txRide.setRideStatus("canceled");
        return txRideService.save(txRide);
    }

    @PutMapping("/assign")
    public List<TxRide> assign(@RequestBody List<TxRideDTO> txRideDTOS) {
        List<TxRide> txRides = new ArrayList<>();
        TxRide txRide;
        Bus bus;
        Employee employee;
        for (TxRideDTO txRideDTO: txRideDTOS) {
            txRide = txRideService.getTxRideById(txRideDTO.getId());
            txRide.setRideStatus("process");
            bus = busService.getBusById(txRideDTO.getBus().getId());
            employee = employeeService.getEmployeeById(txRideDTO.getEmp().getId());
            txRide.setBus(bus);
            txRide.setEmp(employee);
            txRides.add(txRide);
        }
        return txRideService.saveList(txRides);
    }

    @PutMapping("/completed")
    public TxRide completed(@RequestParam("id") int rideId) {
        TxRide txRide = txRideService.getTxRideById(rideId);
        txRide.setRideStatus("complete");
        return txRideService.save(txRide);
    }


}