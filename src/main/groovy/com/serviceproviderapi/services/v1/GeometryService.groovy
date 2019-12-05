package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Geometry
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.GeometryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.geo.Point
import org.springframework.stereotype.Service

@Service
class GeometryService {

    @Autowired
    GeometryRepository geometryRepository

    void saveGeometry(Geometry geometry) {
        geometryRepository.save(geometry)
    }

    void createGeometry(Services services, List<Point> points) {
        Geometry geometry1 = new Geometry(
                serviceId: services,
                geometry: points
        )
        saveGeometry(geometry1)
    }

    void addGeometryToService(List<Point> points, Services services) {
        createGeometry(services, points)
    }


}
