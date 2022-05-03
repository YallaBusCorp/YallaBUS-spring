package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.BusDTO;
import com.alphaq.yallabusserver.entity.Bus;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.service.BusService;
import com.alphaq.yallabusserver.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Bus> getAllBuss() {
        return busService.getAllBuss();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Bus> getAllBussByCompanyId(@RequestParam("id") int companyId) {
        return busService.getAllBussByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Bus getBusById(@RequestParam("id") int busId) {
        return busService.getBusById(busId);
    }

    @PostMapping("/save-bus")
    public Bus save(@RequestBody BusDTO busDTO) {
        Bus bus = new Bus();

        Company company = companyService.getCompanyById(busDTO.getCompany().getId());
        bus.setCompany(company);
        return busService.save(bus);
    }


}