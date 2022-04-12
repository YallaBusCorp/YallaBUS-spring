package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.repository.LkTownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LkTownDAO {
    @Autowired
    private LkTownRepository repository;

    public LkTown save(LkTown lkTown) {
        return repository.save(lkTown);
    }

    public List<LkTown> getAllLkTowns() {
        List<LkTown> lkTowns = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(lkTowns::add);
        return lkTowns;
    }

    public List<LkTown> getAllLkTownsInCompany(int companyId) {
        List<LkTown> lkTowns = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(lkTown -> {
                    if (lkTown.getCompany().getId() == companyId)
                        lkTowns.add(lkTown);
                });
        return lkTowns;
    }

    public LkTown getLKTownByIdAndCompanyId(LkTown lkTown, int companyId) {
        LkTown town = new LkTown();
        town = repository.findLKTownByIdAndCompanyId(lkTown.getId(),companyId);
        return town;
    }

    public Optional<LkTown> getLKTownById(LkTown lkTown) {
        return repository.findById(lkTown.getId());
    }

    public int getCount() {
        return (int) repository.count();
    }
}
