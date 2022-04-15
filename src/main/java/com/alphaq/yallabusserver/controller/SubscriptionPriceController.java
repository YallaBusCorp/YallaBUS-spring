package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.SubscriptionPriceDAO;
import com.alphaq.yallabusserver.dto.SubscriptionPriceDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SubscriptionPriceController {

    @Autowired
    private SubscriptionPriceDAO subscriptionPriceDAO;
    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/subscriptionPrice/get-all")
    public List<SubscriptionPrice> getAllSubscriptionPrices() {
        return subscriptionPriceDAO.getAllSubscriptionPrices();
    }

    @RequestMapping(value = "/subscriptionPrice/get-by-company-id", method = RequestMethod.GET)
    public List<SubscriptionPrice> getSubscriptionPricesByCompanyId(@RequestParam("id") int companyId) {
        return subscriptionPriceDAO.getSubscriptionPricesByCompanyId(companyId);
    }

    @RequestMapping(value = "/subscriptionPrice/get-by-id", method = RequestMethod.GET)
    public SubscriptionPrice getSubscriptionPriceById(@RequestParam("id") int subscriptionPriceId) {
        return subscriptionPriceDAO.getSubscriptionPriceById(subscriptionPriceId);
    }

    @PostMapping("/subscriptionPrice/save-subscriptionPrice")
    public SubscriptionPrice save(@RequestBody SubscriptionPriceDTO subscriptionPriceDTO) {
        SubscriptionPrice subscriptionPrice = new SubscriptionPrice();

        Company company = companyDAO.getCompanyById(subscriptionPriceDTO.getCompany().getId());
        subscriptionPrice.setCompany(company);
        return subscriptionPriceDAO.save(subscriptionPrice);
    }


}