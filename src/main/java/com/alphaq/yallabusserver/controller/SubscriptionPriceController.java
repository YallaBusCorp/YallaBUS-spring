package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.SubscriptionPriceDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.SubscriptionPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<SubscriptionPrice> getAllSubscriptionPricesByCompanyId(@RequestParam("id") int companyId) {
        return subscriptionPriceService.getAllSubscriptionPricesByCompanyId(companyId);
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public SubscriptionPrice getSubscriptionPriceById(@RequestParam("id") int subscriptionPriceId) {
        return subscriptionPriceService.getSubscriptionPriceById(subscriptionPriceId);
    }

    @RequestMapping(value = "/company/active")
    public SubscriptionPrice getCurrentSubscriptionPriceInCompany(@RequestParam("id") int companyId) {
        return subscriptionPriceService.getCurrentSubscriptionPriceInCompany(companyId);
    }

    @PostMapping("/save-subscriptionPrice")
    public SubscriptionPrice save(@RequestBody SubscriptionPriceDTO subscriptionPriceDTO) {
        SubscriptionPrice newSubscriptionPrice = new SubscriptionPrice();
        Company company = companyService.getCompanyById(subscriptionPriceDTO.getCompany().getId());
        newSubscriptionPrice.setCompany(company);
        newSubscriptionPrice.setSubscriptionPrice(subscriptionPriceDTO.getSubscriptionPrice());
        if (newSubscriptionPrice.getCompany() != null && newSubscriptionPrice.getSubscriptionPrice() != null) {
            SubscriptionPrice oldSubscriptionPrice = null;
            oldSubscriptionPrice = subscriptionPriceService.getCurrentSubscriptionPriceInCompany(newSubscriptionPrice.getCompany().getId());
            if (oldSubscriptionPrice != null) {
                oldSubscriptionPrice.setSubscriptionEndDate(LocalDate.now());
                subscriptionPriceService.save(oldSubscriptionPrice);
            }
        }
        newSubscriptionPrice.setSubscriptionStartDate(LocalDate.now());
        return subscriptionPriceService.save(newSubscriptionPrice);
    }


}