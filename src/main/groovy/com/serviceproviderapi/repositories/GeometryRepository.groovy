package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Geometry
import org.springframework.data.jpa.repository.JpaRepository

interface GeometryRepository extends JpaRepository<Geometry,Long> {
}