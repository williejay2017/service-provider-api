package com.serviceproviderapi.services.v1


import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.ServicesRepository

import com.serviceproviderapi.vos.ServiceRequest
import com.serviceproviderapi.vos.UpdateServicesRequest
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


    Services createService(ServiceRequest serviceRequest, String providerId) {
        Provider provider = providerService.getProvider(providerId)
        Services services = new Services(
                name: serviceRequest.name,
                type: serviceRequest.type,
                provider: provider,
        )

        if (provider.services.contains(services)) {
            throw new BadHttpRequest(detailMessage: 'Service Already Exist')
        }

        saveServices(services)

        if (serviceRequest.address) {
            addressService.addAddressToService(serviceRequest.address, services)
        }

        if (serviceRequest.challenge) {
            challengeService.addChallengeToService(serviceRequest.challenge, services)
        }

        if (serviceRequest.ethnicity) {
            ethnicityService.addEthnicityToService(serviceRequest.ethnicity, services)
        }

        if (serviceRequest.geometry) {
            geometryService.addGeometryToService(serviceRequest.geometry, services)
        }

        if (serviceRequest.language) {
            languageService.addLanguageToService(serviceRequest.language, services)
        }

        services
    }

    Services updateService(UpdateServicesRequest updateServicesRequest, int serviceId) {
        Services update = getService(serviceId)
        updateServicesRequest.name ? update.name = updateServicesRequest.name : update.name
        updateServicesRequest.type ? update.type = updateServicesRequest.type : update.type

        saveServices(update)

        if (updateServicesRequest.address) {
            addressService.updateServiceAddress(updateServicesRequest.address, serviceId, updateServicesRequest.addressId)
        }

        update
    }

    void addToExistingService(UpdateServicesRequest updateServicesRequest, int serviceId) {

        if (updateServicesRequest.geometry) {
            geometryService.addGeometryToService(updateServicesRequest.geometry, serviceId)
        }

        if (updateServicesRequest.language) {
            languageService.addLanguageToService(updateServicesRequest.language, serviceId)
        }

        if (updateServicesRequest.ethnicity) {
            ethnicityService.addEthnicityToService(updateServicesRequest.ethnicity, serviceId)
        }
    }


    Services getService(int serviceId) {
        Services services = servicesRepository.findById(serviceId)
        if (services) {
            return services
        }
        throw new BadRequestException(message: 'service not found', status: HttpStatus.NOT_FOUND)
    }

    List<Services> getAllServices(String providerId) {
        Provider provider = providerService.getProvider(providerId)
        provider.services.unique()
    }


    //just for the demo, not final
    List<Services> getServicesAssociateToChallenge(List<String> challengeIds) {

        List<Services> servicesList = servicesRepository.findAll()
        List<Services> returnList = new ArrayList<Services>()
        challengeIds[0] == servicesList[0].challenges[0].challengeId
        for (int i = 0; i < servicesList.size(); i++) {
            for (int j = 0; j < servicesList[i].challenges.size(); j++) {
                for (int k = 0; k < challengeIds.size(); k++) {
                    if (servicesList[i].challenges[j].challengeId == challengeIds[k]) {
                        returnList.add(servicesList[i])
                    }
                }
            }
        }
        returnList.unique()
    }

    void deleteServices(int serviceId) {
        Services services1 = getService(serviceId)
        servicesRepository.deleteById(services1.id)
    }

    void saveServices(Services services) {
        servicesRepository.save(services)
    }
}
