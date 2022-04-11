package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.repository.SubscriptionPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPriceDAO {
    @Autowired
    SubscriptionPriceRepository repository;
}
