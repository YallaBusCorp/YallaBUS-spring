package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.SubscriptionPrice;
import com.alphaq.yallabusserver.repository.SubscriptionPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionPriceDAO {

    @Autowired
    private SubscriptionPriceRepository repository;

    public SubscriptionPrice save(SubscriptionPrice subscriptionPrice) {
        return repository.save(subscriptionPrice);
    }

    public List<SubscriptionPrice> getAllSubscriptionPrices() {
        List<SubscriptionPrice> subscriptionPrices = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(subscriptionPrices::add);
        return subscriptionPrices;
    }

    public List<SubscriptionPrice> getSubscriptionPricesByCompanyId(int companyId) {
        return repository.findSubscriptionPricesByCompanyId(companyId);
    }

    public SubscriptionPrice checkExistenceSubscriptionPriceInCompany(SubscriptionPrice subscriptionPrice, int companyId) {
        return repository.findSubscriptionPriceByIdAndCompanyId(subscriptionPrice.getId(), companyId);
    }

    public SubscriptionPrice getSubscriptionPriceById(int subscriptionPriceId) {
        return repository.findSubscriptionPriceById(subscriptionPriceId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}