package com.serviceproviderapi.repositories


import com.serviceproviderapi.entities.ProviderServices
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository extends JpaRepository<ProviderServices,Long> {

    List<ProviderServices> findAll()

    List<ProviderServices> findByProviderId(String providerId)

    ProviderServices findById(String serviceId)

   // void delete(String id)
}