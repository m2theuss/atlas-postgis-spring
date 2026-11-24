package com.github.atlas_postgis_spring;

import com.github.atlas_postgis_spring.entity.Spatial;
import com.github.atlas_postgis_spring.repository.SpatialRepository;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ugeojson.builder.UltimateGeoJSONBuilder;
import org.ugeojson.model.GeoJSONObjectDto;
import org.ugeojson.model.geometry.PointDto;
import org.ugeojson.parser.UltimateGeoJSONParser;
import org.ugeojson.parser.util.JtsUGeojsonConversionUtil;

@SpringBootTest
class AtlasPostgisSpringApplicationTests {

	@Autowired
	SpatialRepository spatialRepository;

	@Test
	void conversionTest() {
		Spatial result = spatialRepository.findById(552).get();
		JtsUGeojsonConversionUtil jtsConverter = new JtsUGeojsonConversionUtil();

		System.out.println("-----------------------------");
		var pointJson = UltimateGeoJSONBuilder.getInstance().toGeoJSON(jtsConverter.toPointDto(result.getPoint()));
		System.out.println(pointJson);
		System.out.println("-----------------------------");

		GeoJSONObjectDto parse = UltimateGeoJSONParser.getInstance().parse(pointJson);
		Geometry geo = jtsConverter.toJtsGeometry((PointDto) parse);

	}
}
