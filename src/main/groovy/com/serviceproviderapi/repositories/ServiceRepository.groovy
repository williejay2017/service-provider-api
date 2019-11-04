package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Ethnicity
import com.serviceproviderapi.entities.Geometry
import com.serviceproviderapi.entities.Language
import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.entities.Service
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository extends JpaRepository<Service,Long> {

    List<Service> findByAddress(Address address)

    List<Service> findByLanguage(Language language)

    List<Service> findByEthnicity(Ethnicity ethnicity)

    List<Service> findAll()

    List<Service> findByProvider(Provider provider)

    List<Service> findServiceByGeometry(Geometry geometries)

    void delete(String id)
}