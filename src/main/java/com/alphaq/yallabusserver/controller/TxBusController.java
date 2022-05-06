package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.TxBusDTO;
import com.alphaq.yallabusserver.entity.Bus;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.Employee;
import com.alphaq.yallabusserver.entity.TxBus;
import com.alphaq.yallabusserver.service.BusService;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.EmployeeService;
import com.alphaq.yallabusserver.service.TxBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/txBus")
public class TxBusController {

    @Autowired
    private TxBusService txBusService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BusService busService;

    @GetMapping
    public List<TxBus> getAllTxBuses() {
        return txBusService.getAllTxBuses();
    }

//    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
//    public List<TxBus> getAllTxBussByCompanyId(@RequestParam("id") int companyId) {
//        return txBusService.getAllTxBussByCompanyId(companyId);
//    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public TxBus getTxBusById(@RequestParam("id") int txBusId) {
        return txBusService.getTxBusById(txBusId);
    }

    @PostMapping("/save-txBus")
    public TxBus save(@RequestBody TxBusDTO txBusDTO) {
        TxBus txBus = new TxBus();

        Employee employee = employeeService.getEmployeeById(txBusDTO.getEmp().getId());
        txBus.setEmp(employee);

        Bus bus = busService.getBusById(txBusDTO.getBus().getId());
        txBus.setBus(bus);

        txBus.setLoginDate(LocalDate.now());

        return txBusService.save(txBus);
    }


}