package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.AppointmentDTO;
import com.alphaq.yallabusserver.entity.Appointment;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.service.AppointmentService;
import com.alphaq.yallabusserver.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<Appointment> getAllAppointmentsByCompanyId(@RequestParam("id") int companyId) {
        return appointmentService.getAllAppointmentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/get-all-am", method = RequestMethod.GET)
    public List<Appointment> getAllAMAppointmentsByCompanyId(@RequestParam("id") int companyId){
        return appointmentService.getAllAppointmentsByCompanyIdAndAppointmentType(companyId,"AM");
    }

    @RequestMapping(value = "/company/get-all-bm", method = RequestMethod.GET)
    public List<Appointment> getAllBMAppointmentsByCompanyId(@RequestParam("id") int companyId){
        return appointmentService.getAllAppointmentsByCompanyIdAndAppointmentType(companyId,"BM");
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<Appointment> getAllActiveAppointmentsByCompanyId(@RequestParam("id") int companyId) {
        return appointmentService.getAllActiveAppointmentsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/active/get-all-am", method = RequestMethod.GET)
    public List<Appointment> getAllActiveAMAppointmentsByCompanyId(@RequestParam("id") int companyId){
        return appointmentService.getAllActiveAppointmentsByCompanyIdAndAppointmentType(companyId,"AM");
    }

    @RequestMapping(value = "/company/active/get-all-bm", method = RequestMethod.GET)
    public List<Appointment> getAllActiveBMAppointmentsByCompanyId(@RequestParam("id") int companyId){
        return appointmentService.getAllActiveAppointmentsByCompanyIdAndAppointmentType(companyId,"BM");
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public Appointment getAppointmentById(@RequestParam("id") int appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping("/save-appointment")
    public Appointment save(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();

        Company company = companyService.getCompanyById(appointmentDTO.getCompany().getId());
        appointment.setCompany(company);
        return appointmentService.save(appointment);
    }


}