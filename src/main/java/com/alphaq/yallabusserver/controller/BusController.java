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
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Bus> getAllBussByCompanyId(@RequestParam("id") int companyId) {
        return busService.getAllBusesByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Bus getBusById(@RequestParam("id") int busId) {
        return busService.getBusById(busId);
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<Bus> getAllActiveBusesByCompanyId(@RequestParam("id") int companyId) {
        return busService.getAllActiveBusesByCompanyId(companyId);
    }

    @PostMapping("/save-bus")
    public Bus save(@RequestBody BusDTO busDTO) {
        Bus bus = new Bus();

        if (busDTO.getId() != null)
            bus.setId(busDTO.getId());

        Company company = companyService.getCompanyById(busDTO.getCompany().getId());
        bus.setCompany(company);
        bus.setBusCode(busDTO.getBusCode());
        bus.setPhone(busDTO.getPhone());
        bus.setModel(busDTO.getModel());
        bus.setCapacity(busDTO.getCapacity());
        bus.setBusLicenceNumber(busDTO.getBusLicenceNumber());
        bus.setBusLicenceExpirationDate(busDTO.getBusLicenceExpirationDate());
        bus.setBusLicenceExpirationDateAlarm(busDTO.getBusLicenceExpirationDate().minusMonths(1));
        bus.setIsActive(true);

        return busService.save(bus);
    }

    @PutMapping("/update-bus")
    public Bus update(@RequestBody BusDTO busDTO) {
        return save(busDTO);
    }

    @PutMapping("/delete-bus")
    public Boolean update(@RequestParam("id") int busId) {
        Bus bus = busService.getBusById(busId);
        bus.setIsActive(false);
        return !busService.save(bus).getIsActive() ? true : false;
    }

}