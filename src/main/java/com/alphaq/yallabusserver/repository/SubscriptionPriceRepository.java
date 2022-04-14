package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPriceRepository extends JpaRepository<SubscriptionPrice,Integer> {

}
