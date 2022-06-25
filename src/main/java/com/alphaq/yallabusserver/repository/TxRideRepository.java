package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.TxRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TxRideRepository extends JpaRepository<TxRide, Integer> {

    TxRide findTxRideById(int txRideId);

    TxRide findTxRideByIdAndAppointmentCompanyId(int txRideId, int companyId);

    List<TxRide> findTxRidesByAppointmentCompanyId(int companyId);

    List<TxRide> findTxRidesByRideData(LocalDate rideData);

    List<TxRide> findTxRidesByAppointmentCompanyIdAndRideData(int companyId,LocalDate rideData);

    List<TxRide> findTxRidesByAppointmentCompanyIdAndRideStatus(int companyId,String rideStatus);
    List<TxRide> findTxRidesByAppointmentCompanyIdAndRideStatusEqualsAndEmpIsNullAndBusIsNull(int companyId,String rideStatus);

}