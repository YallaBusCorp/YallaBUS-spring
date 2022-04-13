package com.alphaq.yallabusserver.dao;

import com.alphaq.yallabusserver.entity.LkUniversity;
import com.alphaq.yallabusserver.repository.LkUniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LkUniversityDAO {
    @Autowired
    private LkUniversityRepository repository;

    public LkUniversity save(LkUniversity lkUniversity) {
        return repository.save(lkUniversity);
    }

    public List<LkUniversity> getAllLkUniversities() {
        List<LkUniversity> lkUniversities = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(lkUniversities::add);
        return lkUniversities;
    }

    public List<LkUniversity> getLkUniversitiesByCompanyId(int companyId) {
        return repository.findLkUniversitiesByCompanyId(companyId);
    }

    public LkUniversity checkExistenceUniversityInCompany(LkUniversity lkUniversity, int companyId) {
        return repository.findLkUniversityByIdAndCompanyId(lkUniversity.getId(), companyId);
    }

    public LkUniversity getLkUniversityById(int UniversityId) {
        return repository.findLkUniversityById(UniversityId);
    }

    public int getCount() {
        return (int) repository.count();
    }
}
