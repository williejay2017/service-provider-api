package com.serviceproviderapi.services.v1

import com.fasterxml.jackson.databind.ObjectMapper
import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Address
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

    @Autowired
    AddressService addressService

    @Autowired
    ChallengeService challengeService


    Services createService (ServiceRequest serviceRequest, String providerId) {
        Provider provider = providerService.getProvider(providerId)
        Services services = new Services(
                id: serviceRequest.id,
                name: serviceRequest.name,
                type: serviceRequest.type,
                provider: provider,
        )
        if(provider.services.contains(services)) {
            throw new BadHttpRequest(detailMessage: 'Service Already Exist')
        }
        servicesRepository.save(services)

        if(serviceRequest.address.size() > 0) {
            for(address in serviceRequest.address) {
                addressService.createAddress(address, services)
            }
        }

        if(serviceRequest.challenge.size() > 0) {
            for(challenge in serviceRequest.challenge) {
                challengeService.createChallenge(services, challenge.challengeId)
            }
        }
        services
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
        provider.services
    }

    Services updateService (ServiceRequest serviceRequest) {
       Services update = servicesRepository.findById(serviceRequest.id)
        update.name = serviceRequest.name
        update.type = serviceRequest.type
        servicesRepository.save(update)
        update
    }

    //just for the demo, not final
    List<Services> getServicesAssociateToChallenge(List<String> challengeIds) {

        List<Services> servicesList = servicesRepository.findAll()
        List<Services> returnList = new ArrayList<Services>()
        challengeIds[0] == servicesList[0].challenges[0].challengeId
        for(int i = 0; i < servicesList.size();  i++) {
           for(int j = 0; j < servicesList[i].challenges.size(); j++) {
               for(int k =0; k < challengeIds.size(); k++) {
                   if(servicesList[i].challenges[j].challengeId == challengeIds[k]) {
                        returnList.add(servicesList[i])
                   }
               }

           }
        }
        returnList
    }

    void saveServices (Services services) {
        servicesRepository.save(services)
    }

    void deleteServices (String serviceId) {
        servicesRepository.deleteById(serviceId)
    }
}
