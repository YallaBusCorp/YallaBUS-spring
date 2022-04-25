package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dto.AppointmentDTO;
import com.alphaq.yallabusserver.dto.CompanyDTO;
import com.alphaq.yallabusserver.entity.Appointment;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.service.AppointmentService;
import com.alphaq.yallabusserver.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

//@SpringBootTest
public class AppointmentTest {
    @Autowired
    CompanyService companyService;
    @Autowired
    AppointmentService appointmentService;

    //@Test
    void addAppointment(){
        int companyId = 1;
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(companyId);
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setCompany(companyDTO);
        appointmentDTO.setAppointmentStartTime(LocalTime.parse("10:15"));
        appointmentDTO.setAppointmentType("PM");

        Appointment appointment = new Appointment();
        Company company = companyService.getCompanyById(appointmentDTO.getCompany().getId());
        appointment.setCompany(company);
        appointment.setAppointmentStartTime(appointmentDTO.getAppointmentStartTime());
        appointment.setAppointmentType(appointmentDTO.getAppointmentType());
        appointment.setIsActive(true);

        Appointment result = appointmentService.save(appointment);
        System.out.println(result);

    }
}
