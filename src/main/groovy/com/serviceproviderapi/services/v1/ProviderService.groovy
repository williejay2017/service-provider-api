package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.entities.ProviderServices
import com.serviceproviderapi.repositories.ProviderRepository
import com.serviceproviderapi.repositories.ServiceRepository
import javassist.tools.web.BadHttpRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProviderService {

    @Autowired
    ProviderRepository providerRepository

    @Autowired
    ServiceRepository serviceRepository


    Provider createProvider(String id, String organization_id, String name, String email, String phone, String fax) {
        if(providerRepository.findById(id)) {
            throw new BadHttpRequest(detailMessage: 'Provider exist')
        }
        Provider provider = new Provider(
                id: id,
                organization_id: organization_id,
                name: name,
                email: email,
                phone: phone,
                fax: fax
        )
        providerRepository.save(provider)
        provider
    }

    Provider updateProvider(String id, String name, String email, String phone, String fax) {
        Provider provider = getProvider(id)
        provider.id = id
        provider.name = name
        provider.email = email
        provider.phone = phone
        provider.fax = fax
        providerRepository.save(provider)
        provider
    }

//    void deleteProvider(String id) {
//        Provider provider = getProvider(id)
//        providerRepository.delete(provider)
//    }


    List<Provider> getAllProviders(String organization_id) {
        providerRepository.findAllById(organization_id)
    }

    Provider getProvider(String id) {
        Provider provider = providerRepository.findById(id)
        if(!provider) { throw new BadHttpRequest(detailMessage: 'Provider Does Not Exist')}
        provider
    }

    ProviderServices createService(String service_id, String provider_id, String service_name, service_type) {
        ProviderServices services = serviceRepository.findById(service_id)
        if(services) {
            throw new BadHttpRequest(detailMessage: 'Service already exist')
        }
        ProviderServices service = new ProviderServices(
                id: service_id,
                providerId: provider_id,
                name: service_name,
                type: service_type
        )
        serviceRepository.save(service)
    }

    ProviderServices getService(String service_id) {
        ProviderServices providerServices = serviceRepository.findByServiceId(service_id)
        providerServices
    }

    List<ProviderServices> getAllServices(String provider_id) {
       serviceRepository.findByProviderId(provider_id)
    }

//    void deleteService(String service_id) {
//        serviceRepository.delete(service_id)
//    }
//
//    void deleteAllServices() {
//        serviceRepository.deleteAll()
//    }
}
