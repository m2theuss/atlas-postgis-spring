package com.github.atlas_postgis_spring.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.*;

@Entity
@Table(name =  "spatial_types")
public class SpatialTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private Point point;
    private MultiPoint multiPoint;
    private LineString lineString;
    private MultiLineString multiLineString;
    private Polygon polygon;
    private MultiPolygon multiPolygon;
    private GeometryCollection geometryCollection;

    public SpatialTypes(){}
    // all-args constructor excluding auto-generated id
    public SpatialTypes(
            Point point,
            MultiPoint multiPoint,
            LineString lineString,
            MultiLineString multiLineString,
            Polygon polygon,
            MultiPolygon multiPolygon,
            GeometryCollection geometryCollection) {
        this.point = point;
        this.multiPoint = multiPoint;
        this.lineString = lineString;
        this.multiLineString = multiLineString;
        this.polygon = polygon;
        this.multiPolygon = multiPolygon;
        this.geometryCollection = geometryCollection;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public MultiPoint getMultiPoint() {
        return multiPoint;
    }

    public void setMultiPoint(MultiPoint multiPoint) {
        this.multiPoint = multiPoint;
    }

    public LineString getLineString() {
        return lineString;
    }

    public void setLineString(LineString lineString) {
        this.lineString = lineString;
    }

    public MultiLineString getMultiLineString() {
        return multiLineString;
    }

    public void setMultiLineString(MultiLineString multiLineString) {
        this.multiLineString = multiLineString;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public MultiPolygon getMultiPolygon() {
        return multiPolygon;
    }

    public void setMultiPolygon(MultiPolygon multiPolygon) {
        this.multiPolygon = multiPolygon;
    }

    public GeometryCollection getGeometryCollection() {
        return geometryCollection;
    }

    public void setGeometryCollection(GeometryCollection geometryCollection) {
        this.geometryCollection = geometryCollection;
    }
}
