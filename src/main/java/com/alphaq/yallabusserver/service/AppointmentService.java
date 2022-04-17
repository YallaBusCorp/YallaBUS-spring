package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.Appointment;
import com.alphaq.yallabusserver.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(appointments::add);
        return appointments;
    }

    public List<Appointment> getAllAppointmentsByCompanyId(int companyId) {
        return repository.findAppointmentsByCompanyId(companyId);
    }

    public List<Appointment> getAllActiveAppointmentsByCompanyId(int companyId) {
        return repository.findAppointmentsByCompanyIdAndIsActive(companyId,true);
    }

    public List<Appointment> getAllAppointmentsByCompanyIdAndAppointmentType(int companyId,String type) {
        return repository.findAppointmentsByCompanyIdAndAppointmentType(companyId,type);
    }

    public List<Appointment> getAllActiveAppointmentsByCompanyIdAndAppointmentType(int companyId,String type) {
        return repository.findAppointmentsByCompanyIdAndAppointmentTypeAndIsActive(companyId,type,true);
    }

    public Appointment checkExistenceAppointmentInCompany(Appointment appointment, int companyId) {
        return repository.findAppointmentByIdAndCompanyId(appointment.getId(), companyId);
    }

    public Appointment getAppointmentById(int appointmentId) {
        return repository.findAppointmentById(appointmentId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}