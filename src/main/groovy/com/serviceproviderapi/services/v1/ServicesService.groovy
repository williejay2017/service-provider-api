package com.serviceproviderapi.services.v1

import com.fasterxml.jackson.databind.ObjectMapper
import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Challenge
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

    @Autowired
    GeometryService geometryService

    @Autowired
    EthnicityService ethnicityService

    @Autowired
    LanguageService languageService


    Services createService (ServiceRequest serviceRequest, String providerId) {
        Provider provider = providerService.getProvider(providerId)
        Services services = new Services(
                name: serviceRequest.name,
                type: serviceRequest.type,
                provider: provider,
        )

        if(provider.services.contains(services)) {
            throw new BadHttpRequest(detailMessage: 'Service Already Exist')
        }

        servicesRepository.save(services)

        if(serviceRequest.address) {
            addressService.addAddressToService(serviceRequest.address, services)
        }

        if(serviceRequest.challenge) {
            challengeService.addChallengeToService(serviceRequest.challenge, services)
        }

        if(serviceRequest.ethnicity) {
            ethnicityService.addEthnicityToService(serviceRequest.ethnicity, services)
        }

        if(serviceRequest.geometry) {
            geometryService.addGeometryToService(serviceRequest.geometry, services)
        }

        if(serviceRequest.language) {
            languageService.addLanguageToService(serviceRequest.language, services)
        }

        services
    }


    Services getService (String serviceName) {
        Services services = servicesRepository.findByName(serviceName)
        if(services) {
            return services
        }
        throw new BadRequestException(message: 'service not found', status: HttpStatus.NOT_FOUND)
    }

    List<Services> getAllServices (String providerId) {
        Provider provider = providerService.getProvider(providerId)
        provider.services.unique()
    }

    Services updateService (ServiceRequest serviceRequest) {
       Services update = servicesRepository.findByName(serviceRequest.name)
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
        returnList.unique()
    }

    void deleteServices (String serviceName) {
        Services services1 = servicesRepository.findByName(serviceName)
        servicesRepository.deleteById(services1.id)
    }
}
