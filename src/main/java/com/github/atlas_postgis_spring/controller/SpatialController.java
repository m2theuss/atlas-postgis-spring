package com.github.atlas_postgis_spring.controller;

import com.github.atlas_postgis_spring.entity.SpatialTypes;
import com.github.atlas_postgis_spring.repository.SpatialRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class SpatialController {
    private final SpatialRepository spatialRepository;
    public SpatialController(SpatialRepository repo){
        spatialRepository = repo;
    }
    @GetMapping
    public String additem(){
        var factory = new GeometryFactory();
        var point = factory.createPoint(new Coordinate(10,10));
        var f = new SpatialTypes();
        f.setPoint(point);
        spatialRepository.save(f);
        return "ok";
    }
}
