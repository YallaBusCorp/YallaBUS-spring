package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionPriceRepository extends JpaRepository<SubscriptionPrice, Integer> {

    SubscriptionPrice findSubscriptionPriceById(int subscriptionPriceId);

    SubscriptionPrice findSubscriptionPriceByIdAndCompanyId(int subscriptionPriceId, int companyId);

    List<SubscriptionPrice> findSubscriptionPricesByCompanyId(int companyId);

}