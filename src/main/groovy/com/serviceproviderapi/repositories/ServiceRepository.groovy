package com.serviceproviderapi.repositories


import com.serviceproviderapi.entities.ProviderServices
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository extends JpaRepository<ProviderServices,Long> {

    List<ProviderServices> findByAddress(String service_id)

    List<ProviderServices> findByLanguage(String service_id)

    List<ProviderServices> findByEthnicity(String service_id)

    List<ProviderServices> findAll()

    List<ProviderServices> findByProviderId(String provider_id)

    List<ProviderServices> findByGeometry(String service_id)

    ProviderServices findByServiceId(String service_id)

    void delete(String id)
}