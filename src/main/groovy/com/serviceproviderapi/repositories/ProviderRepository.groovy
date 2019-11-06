package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByProviderIdAndOrganizationId(String id , String organizationId)

    Provider findByName(String name)

    Provider findByEmail(String email)

    Provider findByPhone(String phone)

    Provider findByFax(String fax)

    List<Provider> findAll()

    List<Provider> findAllProviderByOrganizationId(String id)

    void delete(Provider provider)


}