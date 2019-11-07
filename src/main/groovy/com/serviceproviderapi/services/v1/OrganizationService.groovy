package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Organization
import com.serviceproviderapi.repositories.OrganizationRepository
import com.serviceproviderapi.vos.OrganizationRequest
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository
    Organization createOrganization(OrganizationRequest organizationRequest){
        Organization org = new Organization(
                id: organizationRequest.id,
                name: organizationRequest.name,
                contactName: organizationRequest.contactName,
                contactEmail: organizationRequest.contactEmail,
        )
        organizationRepository.save(org)
        org
    }

    //more of an admin method
    void deleteOrganization(String id) {
        Organization organization = findOrganization(id)
        organizationRepository.delete(organization)
    }

    Organization findOrganization(String id) {
        Organization organization = organizationRepository.findById(id)
        if(!organization) {throw new NotFoundException(message: 'Organization not found')}
        organization
    }


    Organization updateOrganization(String orgId, OrganizationRequest organizationRequest) {
        Organization organization = findOrganization(orgId)
        organization.name = organizationRequest.name
        organization.contactEmail = organizationRequest.contactEmail
        organization.contactName = organizationRequest.contactName
        organizationRepository.save(organization)
        organization
    }

}
