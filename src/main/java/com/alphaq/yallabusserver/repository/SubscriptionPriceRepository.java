package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPriceRepository extends CrudRepository <SubscriptionPrice,Integer>{

}
