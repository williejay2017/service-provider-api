package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Organization
import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.ProviderRepository
import com.serviceproviderapi.repositories.ServicesRepository
import com.serviceproviderapi.vos.ProviderRequest
import javassist.tools.web.BadHttpRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

import org.springframework.web.client.HttpClientErrorException

@Service
class ProviderService {

    @Autowired
    ProviderRepository providerRepository

    @Autowired
    ServicesRepository serviceRepository

    @Autowired
    OrganizationService organizationService


    List<Provider> createProvider(ProviderRequest providerRequest, String orgId) {
        Organization organization = organizationService.findOrganization(orgId)
        if(organization.providers.contains(providerRequest)) {
            throw new BadRequestException(message: 'provider exist', status: HttpStatus.FOUND)
        }
        Provider prov = new Provider(
                id: providerRequest.id,
                organization: organization,
                name: providerRequest.name,
                email: providerRequest.email,
                phone: providerRequest.phone,
                fax: providerRequest.fax
        )
        providerRepository.save(prov)
        organization.providers
    }

    Provider updateProvider(ProviderRequest providerRequest) {
        Provider update = providerRepository.findById(providerRequest.id)
        update.name = providerRequest.name
        update.email = providerRequest.email
        update.phone = providerRequest.phone
        update.fax = providerRequest.fax
        providerRepository.save(update)
        update
    }

    void deleteProvider(String providerId) {
        providerRepository.deleteById(providerId)
    }


    List<Provider> getAllProviders(String orgId) {
        Organization organization = organizationService.findOrganization(orgId)
        if(organization) {
            return organization.providers
        }
        throw new BadRequestException(message: 'could not find organization', status: HttpStatus.NOT_FOUND)
    }

    Provider getProvider(String id) {
        Provider provider = providerRepository.findById(id)
        if(provider) {
            return provider
        }
        throw new BadRequestException(message: 'could not find provider', status: HttpStatus.NOT_FOUND)
    }

}
