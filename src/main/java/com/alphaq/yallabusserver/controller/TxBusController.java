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

import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<TxBus> getAllTxBussByCompanyId(@RequestParam("id") int companyId) {
        return txBusService.getAllTxBusesByCompanyId(companyId);
    }

    @RequestMapping(value = "/employee/get-all", method = RequestMethod.GET)
    public List<TxBus> getAllTxBussByEmployeeId(@RequestParam("id") int employeeId) {
        return txBusService.getAllTxBusesByEmployeeId(employeeId);
    }

    @RequestMapping(value = "/bus/get-all", method = RequestMethod.GET)
    public List<TxBus> getAllTxBussByBusId(@RequestParam("id") int busId) {
        return txBusService.getAllTxBusesByBusId(busId);
    }

    @RequestMapping(value = "/date/get-all", method = RequestMethod.GET)
    public List<TxBus> getAllTxBussByDate(@RequestParam("startDate") String startLocalDateTime, @RequestParam("endDate") String endLocalDateTime) {
        return txBusService.getAllTxBusesByDate(LocalDateTime.parse(startLocalDateTime),LocalDateTime.parse(endLocalDateTime));
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public TxBus getTxBusById(@RequestParam("id") int txBusId) {
        return txBusService.getTxBusById(txBusId);
    }

    @PostMapping("/save-txBus")
    public TxBus save(@RequestBody TxBusDTO txBusDTO) {
        TxBus txBus = new TxBus();

        Employee employee = employeeService.getEmployeeById(txBusDTO.getEmp().getId());
        Bus bus = busService.getBusById(txBusDTO.getBus().getId());

        if (bus.getCompany().getId() == employee.getCompany().getId() && employee.getEmpLk().getId() != 1) {
            txBus.setBus(bus);
            txBus.setEmp(employee);
        }

        return txBusService.save(txBus);
    }


}