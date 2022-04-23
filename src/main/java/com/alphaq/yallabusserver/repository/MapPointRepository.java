package com.alphaq.yallabusserver.repository;

import com.alphaq.yallabusserver.entity.MapPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapPointRepository extends JpaRepository<MapPoint, Integer> {

    MapPoint findMapPointById(int mapPointId);
    MapPoint findMapPointByIdAndCompanyId(int mapPointId, int companyId);
    List<MapPoint> findMapPointsByCompanyId(int companyId);
    List<MapPoint> findMapPointsByCompanyIdAndIsActive(int companyId, boolean isActive);
    List<MapPoint> findMapPointsByCompanyIdAndMapPointType(int companyId,Character type);
    List<MapPoint> findMapPointsByCompanyIdAndMapPointTypeAndIsActive(int companyId, Character type, boolean isActive);

}