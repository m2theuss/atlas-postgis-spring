package com.github.atlas_postgis_spring.init;

import com.github.atlas_postgis_spring.repository.SpatialRepository;
import com.github.atlas_postgis_spring.util.SpatialGenerator;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitSpatialService implements ApplicationListener<ApplicationReadyEvent> {
    private final SpatialRepository spatialRepository;
    public InitSpatialService(SpatialRepository repo){
        spatialRepository = repo;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if(spatialRepository.count() > 0){
            System.out.println("Almost have items on database");
            return;
        }
        var allTypes = SpatialGenerator.allTypesGenerator();
        spatialRepository.save(allTypes);
    }
}
