package com.serviceproviderapi.repositories


import com.serviceproviderapi.entities.Services
import org.springframework.data.jpa.repository.JpaRepository

interface ServicesRepository extends JpaRepository<Services,Long> {

    List<Services> findAll()

    List<Services> findByProviderId(String providerId)

    Services findByName(String serviceName)

    Services findById(int serviceId)

    void deleteById(String id)
}

