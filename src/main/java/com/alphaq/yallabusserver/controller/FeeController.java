package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.FeeDTO;
import com.alphaq.yallabusserver.entity.Bus;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.Fee;
import com.alphaq.yallabusserver.entity.LKFee;
import com.alphaq.yallabusserver.service.BusService;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.FeeService;
import com.alphaq.yallabusserver.service.LKFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/bus/get-all", method = RequestMethod.GET)
    public List<Fee> getAllFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllFeesByBusId(busId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Fee getFeeById(@RequestParam("id") int feeId) {
        return feeService.getFeeById(feeId);
    }

    @RequestMapping(value = "/bus/get-all-Approved", method = RequestMethod.GET)
    public List<Fee> getAllApprovedFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllApprovedFeesByBusId(busId);
    }

    @RequestMapping(value = "/bus/get-all-NotApproved", method = RequestMethod.GET)
    public List<Fee> getAllNotApprovedFeesByBusId(@RequestParam("id") int busId) {
        return feeService.getAllNotApprovedFeesByBusId(busId);
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
        fee.setIsApproved('N');

        return feeService.save(fee);
    }

    @PutMapping("/approve-by-fee-id")
    public Boolean approve(@RequestParam("id") int feeId) {
        Fee fee = feeService.getFeeById(feeId);
        fee.setIsApproved('Y');

        return (feeService.save(fee).getIsApproved().equals('Y')) ? true : false;
    }


}