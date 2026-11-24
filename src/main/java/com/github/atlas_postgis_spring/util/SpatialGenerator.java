package com.github.atlas_postgis_spring.util;

import com.github.atlas_postgis_spring.entity.Spatial;
import org.locationtech.jts.geom.*;

public class SpatialGenerator {

    public static Spatial allTypesGenerator() {
        var factory = new GeometryFactory(new PrecisionModel(), 4326);

        var point = factory.createPoint(new Coordinate(-41.11, -20.84));

        var multiPoint = factory.createMultiPointFromCoords(new Coordinate[]{
                new Coordinate(139.69, 35.68),
                new Coordinate(-0.12, 51.50),
                new Coordinate(28.04, -26.20)
        });

        var lineString = factory.createLineString(new Coordinate[]{
                new Coordinate(-74.00, 40.71),
                new Coordinate(-46.63, -23.55),
                new Coordinate(151.20, -33.86)
        });

        var multiLineString = factory.createMultiLineString(new LineString[]{
                factory.createLineString(new Coordinate[]{new Coordinate(2.35, 48.85), new Coordinate(13.40, 52.52)}),
                factory.createLineString(new Coordinate[]{new Coordinate(37.61, 55.75), new Coordinate(116.40, 39.90)})
        });

        var polygon = factory.createPolygon(new Coordinate[]{
                new Coordinate(-60.0, -10.0),
                new Coordinate(-50.0, -10.0),
                new Coordinate(-50.0, 0.0),
                new Coordinate(-60.0, 0.0),
                new Coordinate(-60.0, -10.0)
        });

        var multiPolygon = factory.createMultiPolygon(new Polygon[]{
                factory.createPolygon(new Coordinate[]{
                        new Coordinate(10.0, 40.0),
                        new Coordinate(15.0, 40.0),
                        new Coordinate(15.0, 45.0),
                        new Coordinate(10.0, 45.0),
                        new Coordinate(10.0, 40.0)
                }),
                factory.createPolygon(new Coordinate[]{
                        new Coordinate(-120.0, 30.0),
                        new Coordinate(-115.0, 30.0),
                        new Coordinate(-115.0, 35.0),
                        new Coordinate(-120.0, 35.0),
                        new Coordinate(-120.0, 30.0)
                })
        });

        var geometryCollection = factory.createGeometryCollection(new Geometry[]{
                point,
                lineString,
                polygon
        });

        return new Spatial(
                point,
                multiPoint,
                lineString,
                multiLineString,
                polygon,
                multiPolygon,
                geometryCollection
        );
    }
}
