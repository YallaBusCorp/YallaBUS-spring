package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.SubscriptionPriceService;
import com.alphaq.yallabusserver.dto.SubscriptionPriceDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/subscriptionPrice")
public class SubscriptionPriceController {

    @Autowired
    private SubscriptionPriceService subscriptionPriceService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<SubscriptionPrice> getAllSubscriptionPrices() {
        return subscriptionPriceService.getAllSubscriptionPrices();
    }

    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<SubscriptionPrice> getSubscriptionPricesByCompanyId(@RequestParam("id") int companyId) {
        return subscriptionPriceService.getSubscriptionPricesByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public SubscriptionPrice getSubscriptionPriceById(@RequestParam("id") int subscriptionPriceId) {
        return subscriptionPriceService.getSubscriptionPriceById(subscriptionPriceId);
    }

    @PostMapping("/save-subscription-Price")
    public SubscriptionPrice save(@RequestBody SubscriptionPriceDTO subscriptionPriceDTO) {
        SubscriptionPrice subscriptionPrice = new SubscriptionPrice();

        Company company = companyService.getCompanyById(subscriptionPriceDTO.getCompany().getId());
        subscriptionPrice.setCompany(company);
        return subscriptionPriceService.save(subscriptionPrice);
    }


}