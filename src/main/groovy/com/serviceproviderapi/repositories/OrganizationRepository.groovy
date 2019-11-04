package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Organization
import org.springframework.data.jpa.repository.JpaRepository

interface OrganizationRepository extends JpaRepository<Organization, Long> {

    void delete(Organization organization)

    Organization findByOrganizationId(String id)
}