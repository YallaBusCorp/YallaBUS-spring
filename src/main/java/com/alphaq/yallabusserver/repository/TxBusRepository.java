package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.TxBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxBusRepository extends JpaRepository<TxBus, Integer> {

    TxBus findTxBusById(int txBusId);

//    TxBus findTxBusByIdAndCompanyId(int txBusId, int companyId);

//    List<TxBus> findTxBussByCompanyId(int companyId);

}