package com.github.atlas_postgis_spring.repository;

import com.github.atlas_postgis_spring.entity.SpatialTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpatialRepository extends JpaRepository<SpatialTypes, Integer> {
}
