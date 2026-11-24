package com.github.atlas_postgis_spring.controller;

import com.github.atlas_postgis_spring.entity.Spatial;
import com.github.atlas_postgis_spring.service.SpatialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.locationtech.jts.geom.Point;
import org.ugeojson.model.geometry.PointDto;

@RestController
@RequestMapping("/api/spatials")
public class SpatialController {
    private final SpatialService spatialService;
    public SpatialController(SpatialService spatialService){
        this.spatialService = spatialService;
    }

    @GetMapping("/{id}")
    public String addItem(@PathVariable int id){
        return spatialService.getItemById(id).toString();
    }
}
