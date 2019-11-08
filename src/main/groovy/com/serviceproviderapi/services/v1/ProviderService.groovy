package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException

import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.repositories.ProviderRepository
import com.serviceproviderapi.vos.ProviderRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ProviderService {

    @Autowired
    ProviderRepository providerRepository



   Provider createProvider(ProviderRequest providerRequest) {
        Provider provider = providerRepository.findById(providerRequest.id)
        if(provider) {
            throw new BadRequestException(message: 'provider exist', status: HttpStatus.FOUND)
        }
        Provider prov = new Provider(
                id: providerRequest.id,
                name: providerRequest.name,
                email: providerRequest.email,
                phone: providerRequest.phone,
                fax: providerRequest.fax
        )
        providerRepository.save(prov)
        prov
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


    Provider getProvider(String id) {
        Provider provider = providerRepository.findById(id)
        if(provider) {
            return provider
        }
        throw new BadRequestException(message: 'could not find provider', status: HttpStatus.NOT_FOUND)
    }

}
