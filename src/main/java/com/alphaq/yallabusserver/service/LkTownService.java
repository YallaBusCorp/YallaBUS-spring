package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.repository.LkTownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LkTownService {
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

    public List<LkTown> getAllLkTownsByCompanyId(int companyId) {
        return repository.findLkTownsByCompanyId(companyId);
    }

    public List<LkTown> getAllActiveLkTownsByCompanyId(int companyId){
        return repository.findLkTownsByCompanyIdAndIsActive(companyId,true);
    }

    public LkTown checkExistenceTownInCompany(LkTown lkTown, int companyId) {
        return repository.findLKTownByIdAndCompanyId(lkTown.getId(), companyId);
    }

    public LkTown getLKTownById(int townId) {
        return repository.findLKTownById(townId);
    }

    public int getCount() {
        return (int) repository.count();
    }
}
