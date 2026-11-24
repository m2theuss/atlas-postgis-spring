package com.github.atlas_postgis_spring.service;

import com.github.atlas_postgis_spring.entity.Spatial;
import com.github.atlas_postgis_spring.repository.SpatialRepository;
import org.springframework.stereotype.Service;
import org.ugeojson.model.geometry.PointDto;
import org.ugeojson.parser.util.JtsUGeojsonConversionUtil;

import java.util.Optional;
@Service
public class SpatialService {
    SpatialRepository spatialRepository;
    public SpatialService(SpatialRepository spatialRepository){
        this.spatialRepository = spatialRepository;
    }
    public PointDto getItemById(int id){
        JtsUGeojsonConversionUtil util = new JtsUGeojsonConversionUtil();
        var resultDb =  spatialRepository.findById(id).map(e -> {
            return  util.toPointDto(e.getPoint());
        });
        return null;
    }
}
