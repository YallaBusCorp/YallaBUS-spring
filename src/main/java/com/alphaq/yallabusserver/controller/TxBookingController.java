package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.TxBookingDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.TxBooking;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.TxBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/txBooking")
public class TxBookingController {

    @Autowired
    private TxBookingService txBookingService;
    @Autowired
    private CompanyService companyService;

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

//        Company company = companyService.getCompanyById(txBookingDTO.getCompany().getId());
//        txBooking.setCompany(company);
        return txBookingService.save(txBooking);
    }


}