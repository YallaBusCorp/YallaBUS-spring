package com.alphaq.yallabusserver.service;

import com.alphaq.yallabusserver.entity.MapPoint;
import com.alphaq.yallabusserver.repository.MapPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapPointService {

    @Autowired
    private MapPointRepository repository;

    public MapPoint save(MapPoint mapPoint) {
        return repository.save(mapPoint);
    }

    public List<MapPoint> getAllMapPoints() {
        List<MapPoint> mapPoints = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(mapPoints::add);
        return mapPoints;
    }

    public List<MapPoint> getAllMapPointsByCompanyId(int companyId) {
        return repository.findMapPointsByCompanyId(companyId);
    }

    public List<MapPoint> getAllActiveMapPointsByCompanyId(int companyId) {
        return repository.findMapPointsByCompanyIdAndIsActive(companyId,true);
    }

    public List<MapPoint> getAllMapPointsByCompanyIdAndMapPointType(int companyId,Character type) {
        return repository.findMapPointsByCompanyIdAndMapPointType(companyId,type);
    }

    public List<MapPoint> getAllActiveMapPointsByCompanyIdAndMapPointType(int companyId,Character type) {
        return repository.findMapPointsByCompanyIdAndMapPointTypeAndIsActive(companyId,type,true);
    }

    public MapPoint checkExistenceMapPointInCompany(MapPoint mapPoint, int companyId) {
        return repository.findMapPointByIdAndCompanyId(mapPoint.getId(), companyId);
    }

    public MapPoint getMapPointById(int mapPointId) {
        return repository.findMapPointById(mapPointId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}