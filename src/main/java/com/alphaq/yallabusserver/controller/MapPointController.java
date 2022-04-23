package com.alphaq.yallabusserver.controller;

import com.alphaq.yallabusserver.dto.MapPointDTO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.MapPoint;
import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.MapPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/mapPoint")
public class MapPointController {

    @Autowired
    private MapPointService mapPointService;
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<MapPoint> getAllMapPoints() {
        return mapPointService.getAllMapPoints();
    }


    @RequestMapping(value = "/company/get-all", method = RequestMethod.GET)
    public List<MapPoint> getAllMapPointsByCompanyId(@RequestParam("id") int companyId) {
        return mapPointService.getAllMapPointsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/get-all-pick", method = RequestMethod.GET)
    public List<MapPoint> getAllPickMapPointsByCompanyId(@RequestParam("id") int companyId) {
        return mapPointService.getAllMapPointsByCompanyIdAndMapPointType(companyId, 'P');
    }

    @RequestMapping(value = "/company/get-all-drop", method = RequestMethod.GET)
    public List<MapPoint> getAllDropMapPointsByCompanyId(@RequestParam("id") int companyId) {
        return mapPointService.getAllMapPointsByCompanyIdAndMapPointType(companyId, 'D');
    }

    @RequestMapping(value = "/company/active", method = RequestMethod.GET)
    public List<MapPoint> getAllActiveMapPointsByCompanyId(@RequestParam("id") int companyId) {
        return mapPointService.getAllActiveMapPointsByCompanyId(companyId);
    }

    @RequestMapping(value = "/company/active/get-all-pick", method = RequestMethod.GET)
    public List<MapPoint> getAllActivePickMapPointsByCompanyId(@RequestParam("id") int companyId) {
        return mapPointService.getAllActiveMapPointsByCompanyIdAndMapPointType(companyId, 'P');
    }

    @RequestMapping(value = "/company/active/get-all-drop", method = RequestMethod.GET)
    public List<MapPoint> getAllActiveDropMapPointsByCompanyId(@RequestParam("id") int companyId) {
        return mapPointService.getAllActiveMapPointsByCompanyIdAndMapPointType(companyId, 'D');
    }

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public MapPoint getMapPointById(@RequestParam("id") int mapPointId) {
        return mapPointService.getMapPointById(mapPointId);
    }

    @PostMapping("/save-mapPoint")
    public MapPoint save(@RequestBody MapPointDTO mapPointDTO) {
        MapPoint mapPoint = new MapPoint();
        Company company = companyService.getCompanyById(mapPointDTO.getCompany().getId());
        mapPoint.setCompany(company);
        mapPoint.setMapPointTitle(mapPointDTO.getMapPointTitle());
        mapPoint.setMapPointType(mapPointDTO.getMapPointType());
        mapPoint.setLatitude(mapPointDTO.getLatitude());
        mapPoint.setLongitude(mapPointDTO.getLongitude());
        mapPoint.setIsActive(true);
        return mapPointService.save(mapPoint);
    }

    @PutMapping("/update-mapPoint")
    public MapPoint update(@RequestBody MapPointDTO mapPointDTO) {
        MapPoint mapPoint = new MapPoint();
        mapPoint.setId(mapPointDTO.getId());
        Company company = companyService.getCompanyById(mapPointDTO.getCompany().getId());
        mapPoint.setCompany(company);
        mapPoint.setMapPointTitle(mapPointDTO.getMapPointTitle());
        mapPoint.setMapPointType(mapPointDTO.getMapPointType());
        mapPoint.setLatitude(mapPointDTO.getLatitude());
        mapPoint.setLongitude(mapPointDTO.getLongitude());
        mapPoint.setIsActive(mapPointDTO.getIsActive());
        return mapPointService.save(mapPoint);
    }

    @PutMapping("/delete-mapPoint")
    public Boolean delete(@RequestParam("id") int mapPointId) {
        MapPoint mapPoint = mapPointService.getMapPointById(mapPointId);
        mapPoint.setIsActive(false);
        MapPoint result = mapPointService.save(mapPoint);
        return !result.getIsActive() ? true : false;
    }

}