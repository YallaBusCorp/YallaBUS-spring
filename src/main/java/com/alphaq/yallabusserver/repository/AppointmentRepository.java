package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Appointment findAppointmentById(int appointmentId);
    Appointment findAppointmentByIdAndCompanyId(int appointmentId, int companyId);
    List<Appointment> findAppointmentsByCompanyId(int companyId);
    List<Appointment> findAppointmentsByCompanyIdAndIsActive(int companyId,boolean isActive);
    List<Appointment> findAppointmentsByCompanyIdAndAppointmentType(int companyId,String type);
    List<Appointment> findAppointmentsByCompanyIdAndAppointmentTypeAndIsActive(int companyId,String type,boolean isActive);

}