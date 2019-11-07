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
    Organization createOrganization(Organization organization){
        Organization org = new Organization(
                id: organization.id,
                name: organization.name,
                contactName: organization.contactName,
                contactEmail: organization.contactEmail,
        )
        organizationRepository.save(org)
        organization
    }

    void deleteOrganization(String id) {
        Organization organization = findOrganization(id)
        organizationRepository.delete(organization)
    }

    Organization findOrganization(String id) {
        Organization organization = organizationRepository.findById(id)
        if(!organization) {throw new NotFoundException(message: 'Organization not found')}
        organization
    }

    void saveOrganization(Organization organization) {
        organizationRepository.save(organization)
    }

    Organization updateOrganization(Organization organization) {
        Organization org = findOrganization(organization.id)
        org.name = organization.name
        org.contactEmail = organization.contactEmail
        org.contactName = organization.contactName
        organizationRepository.save(org)
        org
    }

}
