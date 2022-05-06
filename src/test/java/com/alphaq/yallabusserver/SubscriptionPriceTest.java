package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dto.CompanyDTO;
import com.alphaq.yallabusserver.dto.SubscriptionPriceDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.SubscriptionPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

//@SpringBootTest
public class SubscriptionPriceTest {

    @Autowired
    CompanyService companyService;
    @Autowired
    SubscriptionPriceService subscriptionPriceService;

    //@Test
    public void save(){
        int companyId = 1;
        int price = 650;

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(companyId);
        SubscriptionPriceDTO subscriptionPriceDTO = new SubscriptionPriceDTO();
        subscriptionPriceDTO.setCompany(companyDTO);
        subscriptionPriceDTO.setSubscriptionPrice(price);

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
        SubscriptionPrice subscriptionPrice = subscriptionPriceService.save(newSubscriptionPrice);
        System.out.println(subscriptionPrice);

    }
}
