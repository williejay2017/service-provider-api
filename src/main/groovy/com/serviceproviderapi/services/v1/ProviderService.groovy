package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.repositories.ProviderRepository
import javassist.tools.web.BadHttpRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProviderService {

    @Autowired
    ProviderRepository providerRepository

    Provider createProvider(String id, String organizationId, String name, String email, String phone, String fax) {
        if(providerRepository.findProviderByProviderId(id)) {
            throw new BadHttpRequest(detailMessage: 'Provider exist')
        }
        Provider provider = new Provider(
                id: id,
                organizationId: organizationId,
                name: name,
                email: email,
                phone: phone,
                fax: fax
        )
        providerRepository.save(provider)
        provider
    }

    Provider updateProvider(String id, String name, String email, String phone, String fax) {
        Provider provider = providerRepository.findProviderByProviderId(id)
        provider.id = id
        provider.name = name
        provider.email = email
        provider.phone = phone
        provider.fax = fax
        providerRepository.save(provider)
        provider

    }

    void deleteProvider(String id) {
        providerRepository.delete(id)
    }

    void deleteAllProviders(String organizationId) {
        providerRepository.deleteAll(organizationId)
    }

    List<Provider> getAllProviders(String organizationId) {
        providerRepository.findAllProviderByOrgId(organizationId)
    }

    Provider getProvider(String id) {
        Provider provider = providerRepository.findProviderByProviderId(id)
        if(!provider) { throw new BadHttpRequest(detailMessage: 'Provider Does Not Exist')}
        provider
    }
}
