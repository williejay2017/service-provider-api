package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findById(String id)

    List<Provider> findAll()

    void deleteById(String id)

}