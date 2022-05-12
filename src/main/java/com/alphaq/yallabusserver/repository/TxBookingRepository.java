package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.TxBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxBookingRepository extends JpaRepository<TxBooking, Integer> {

    TxBooking findTxBookingById(int txBookingId);

    TxBooking findTxBookingByIdAndStd_CompanyId(int txBookingId, int companyId);

    List<TxBooking> findTxBookingsByStd_CompanyId(int companyId);

    List<TxBooking> findTxBookingsByStdId(int stdId);

    List<TxBooking> findTxBookingsByStdIdAndIsScanned(int stdId, Boolean isScanned);

    List<TxBooking> findTxBookingsByStd_CompanyIdAndAppointmentIdAndEmpIsNullAndBusIsNull(int companyId, int appointmentId);
    List<TxBooking> findTxBookingsByStd_CompanyIdAndEmpIsNullAndBusIsNull(int companyId);

    TxBooking findTxBookingByQrCode(String qrCode);

    TxBooking findTopByStdStdUidOrderByBookingDataDesc(String stdUid);

    //TxBooking findTopByStdIdOrderByBookingDataDesc(int stdId);
}