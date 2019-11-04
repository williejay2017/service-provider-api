package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findProviderByProviderId(String id)

    Provider findByOrganizationId(String id)

    Provider findByName(String name)

    Provider findByEmail(String email)

    Provider findByPhone(String phone)

    Provider findByFax(String fax)

    List<Provider> findAll()

    List<Provider> findAllProviderByOrgId(String id)

    void delete(String id)

    void deleteAll(String id)

}