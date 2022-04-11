package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.SubscriptionPriceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionPriceController {

    @Autowired
    SubscriptionPriceDAO subscriptionPriceDAO;
}
