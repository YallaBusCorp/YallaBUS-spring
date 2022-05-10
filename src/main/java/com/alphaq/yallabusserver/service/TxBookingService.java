package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.TxBooking;
import com.alphaq.yallabusserver.repository.TxBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TxBookingService {

    @Autowired
    private TxBookingRepository repository;

    public TxBooking save(TxBooking txBooking) {
        return repository.save(txBooking);
    }

    public List<TxBooking> getAllTxBookings() {
        List<TxBooking> txBookings = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(txBookings::add);
        return txBookings;
    }

    public List<TxBooking> getAllTxBookingsByCompanyId(int companyId) {
        return repository.findTxBookingsByStd_CompanyId(companyId);
    }

    public List<TxBooking> getAllTxBookingsByCompanyIdAndAppointmentId(int companyId, int appointmentId) {
        return repository.findTxBookingsByStd_CompanyIdAndAppointmentIdAndEmpIsNullAndBusIsNull(companyId, appointmentId);
    }

    public TxBooking getTxBookingByIdAndCompanyId(int txBookingId, int companyId) {
        return repository.findTxBookingByIdAndStd_CompanyId(txBookingId, companyId);
    }

    public TxBooking getTxBookingById(int txBookingId) {
        return repository.findTxBookingById(txBookingId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}