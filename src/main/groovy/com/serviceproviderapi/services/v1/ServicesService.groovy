package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.ServicesRepository
import com.serviceproviderapi.vos.ServiceRequest
import javassist.tools.web.BadHttpRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ServicesService {

    @Autowired
    ServicesRepository servicesRepository

    @Autowired
    ProviderService providerService


    List<Services> createService (String providerId, ServiceRequest serviceRequest) {
        Provider provider = providerService.getProvider(providerId)
        if(provider.providerServices.contains(serviceRequest)) {
            throw new BadHttpRequest(detailMessage: 'Service Already Exist')
        }
        Services newServices = new Services(
                id: serviceRequest.id,
                name: serviceRequest.name,
                type: serviceRequest.type,
                provider: provider
        )
        servicesRepository.save(newServices)
        provider.providerServices
    }

    Services getService (String serviceId) {
        Services services = servicesRepository.findById(serviceId)
        if(services) {
            return services
        }
        throw new BadRequestException(message: 'service not found', status: HttpStatus.NOT_FOUND)
    }

    List<Services> getAllServices (String providerId) {
        Provider provider = providerService.getProvider(providerId)
        provider.providerServices
    }

    Services updateService (ServiceRequest serviceRequest) {
       Services update = servicesRepository.findById(serviceRequest.id)
        update.name = serviceRequest.name
        update.type = serviceRequest.type
        servicesRepository.save(update)
        update
    }

    void deleteServices (String serviceId) {
        servicesRepository.deleteById(serviceId)
    }
}
