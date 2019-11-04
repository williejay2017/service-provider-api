package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Organization
import com.serviceproviderapi.repositories.OrganizationRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository

    Organization createOrganization(String id, String name, String contactName, String contactEmail){
        Organization organization = new Organization(
                id: id,
                name: name,
                contactName: contactName,
                contactEmail: contactEmail,
        )
        saveOrganization(organization)
        organization
    }

    Organization saveOrganization(Organization organization) {
        organizationRepository.save(organization)
    }

    void deleteOrganization(String id) {
        Organization organization = findOrganization(id)
        organizationRepository.delete(organization)
    }

    Organization findOrganization(String id) {
        Organization organization = organizationRepository.findByOrganizationId(id)
        if(organization) {
            return organization
        }
        throw new NotFoundException(message: 'Organization not found')
    }

    Organization updateOrganization(String id, String name, String contactName, String contactEmail) {
        Organization organization = findOrganization(id)
        organization.name = name
        organization.contactEmail = contactEmail
        organization.contactName = contactName
        organizationRepository.save(organization)
        organization
    }

}
