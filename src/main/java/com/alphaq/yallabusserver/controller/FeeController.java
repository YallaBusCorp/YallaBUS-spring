package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.FeeDTO;
import com.alphaq.yallabusserver.entity.*;
import com.alphaq.yallabusserver.service.BusService;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.FeeService;
import com.alphaq.yallabusserver.service.LKFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/fee")
public class FeeController {

    @Autowired
    private FeeService feeService;
    @Autowired
    private BusService busService;

    @Autowired
    private LKFeeService lkFeeService;

    @GetMapping
    public List<Fee> getAllFees() {
        return feeService.getAllFees();
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Fee getFeeById(@RequestParam("id") int feeId) {
        return feeService.getFeeById(feeId);
    }


    @RequestMapping(value = "/bus/get-all", method = RequestMethod.GET)
    public List<Fee> getAllFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllFeesByBusId(busId);
    }

    @RequestMapping(value = "/bus/get-all-Approved", method = RequestMethod.GET)
    public List<Fee> getAllApprovedFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllApprovedFeesByBusId(busId);
    }

    @RequestMapping(value = "/bus/get-all-NotApproved", method = RequestMethod.GET)
    public List<Fee> getAllNotApprovedFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllNotApprovedFeesByBusId(busId);
    }

    @RequestMapping(value = "/bus/get-all-Pending", method = RequestMethod.GET)
    public List<Fee> getAllPendingFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllPendingFeesByBusId(busId);
    }


    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Fee> getAllFeesByCompanyId(@RequestParam("id") int companyId) {
        return feeService.getAllFeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/get-all-Approved", method = RequestMethod.GET)
    public List<Fee> getAllApprovedFeesByCompanyId(@RequestParam("id") int companyId) {
        return feeService.getAllApprovedFeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/get-all-NotApproved", method = RequestMethod.GET)
    public List<Fee> getAllNotApprovedFeesByCompanyId(@RequestParam("id") int companyId) {
        return feeService.getAllNotApprovedFeesByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/get-all-Pending", method = RequestMethod.GET)
    public List<Fee> getAllPendingFeesByCompanyId(@RequestParam("id") int companyId) {
        return feeService.getAllPendingFeesByCompanyId(companyId);
    }


    @RequestMapping(value = "/companyAndLkFee/get-all", method = RequestMethod.GET)
    public List<Fee> getAllFeesByCompanyIdAndLkFeeId(@RequestParam("companyId") int companyId, @RequestParam("lkFeeId") int lkFeeId) {
        return feeService.getAllFeesByCompanyIdAndLkFeeId(companyId, lkFeeId);
    }

    @RequestMapping(value = "/companyAndLkFee/get-all-Approved", method = RequestMethod.GET)
    public List<Fee> getAllApprovedFeesByCompanyIdAndLkFeeId(@RequestParam("companyId") int companyId, @RequestParam("lkFeeId") int lkFeeId) {
        return feeService.getAllApprovedFeesByCompanyIdAndLkFeeId(companyId, lkFeeId);
    }

    @RequestMapping(value = "/companyAndLkFee/get-all-NotApproved", method = RequestMethod.GET)
    public List<Fee> getAllNotApprovedFeesByCompanyIdAndLkFeeId(@RequestParam("companyId") int companyId, @RequestParam("lkFeeId") int lkFeeId) {
        return feeService.getAllNotApprovedFeesByCompanyIdAndLkFeeId(companyId, lkFeeId);
    }

    @RequestMapping(value = "/companyAndLkFee/get-all-Pending", method = RequestMethod.GET)
    public List<Fee> getAllPendingFeesByCompanyIdAndLkFeeId(@RequestParam("companyId") int companyId, @RequestParam("lkFeeId") int lkFeeId) {
        return feeService.getAllPendingFeesByCompanyIdAndLkFeeId(companyId, lkFeeId);
    }


    @RequestMapping(value = "/date/get-all", method = RequestMethod.GET)
    public List<Fee> getAllFeesByDateBetween(@RequestParam("startDate") String startLocalDateTime, @RequestParam("endDate") String endLocalDateTime) {
        return feeService.getAllFeesByDateBetween(LocalDateTime.parse(startLocalDateTime), LocalDateTime.parse(endLocalDateTime));
    }

    @PostMapping("/save-fee")
    public Fee save(@RequestBody FeeDTO feeDTO) {
        Fee fee = new Fee();

        Bus bus = busService.getBusById(feeDTO.getBus().getId());
        fee.setBus(bus);
        LKFee lkFee = lkFeeService.getLKFeeById(feeDTO.getFeesLk().getId());
        fee.setFeesLk(lkFee);

        fee.setPrice(feeDTO.getPrice());
        fee.setImage(feeDTO.getImage());
        fee.setFessDate(feeDTO.getFessDate());

        return feeService.save(fee);
    }

    @PutMapping("/approve-by-fee-id")
    public Boolean approve(@RequestParam("feeId") int feeId, @RequestParam("isApproved") Boolean isApproved) {
        Fee fee = feeService.getFeeById(feeId);
        fee.setIsApproved(isApproved);
        Boolean status = feeService.save(fee).getIsApproved();

        if ((isApproved && status) || (!isApproved && !status))
            return true;

        return false;
    }


}