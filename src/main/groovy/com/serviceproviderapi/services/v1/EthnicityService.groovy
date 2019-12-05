package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Ethnicity
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.EthnicityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EthnicityService {

    @Autowired
    EthnicityRepository ethnicityRepository

    @Autowired
    ServicesService servicesService

    void saveEthnicity(Ethnicity ethnicity) {
        ethnicityRepository.save(ethnicity)
    }

    void createEthnicity(Ethnicity ethnicity, Services services) {
        Ethnicity ethnicity1 = new Ethnicity(
                serviceId: services,
                type: ethnicity.type
        )
        saveEthnicity(ethnicity1)
    }

    void addEthnicityToService(List<Ethnicity> ethnicityList, Services services) {
        for (ethnicity in ethnicityList) {
            createEthnicity(ethnicity, services)
        }
    }

    void addEthnicityToService(Ethnicity ethnicity, int serviceId) {
        Services services1 = servicesService.getService(serviceId)
        Ethnicity ethnicityCheck = services1.ethnicities.find { target -> target.id == ethnicity.id }
        if (ethnicityCheck) {
            throw new BadRequestException(message: 'Ethnicity already exist', status: HttpStatus.FOUND)
        }
        createEthnicity(ethnicity, services1)
    }
}
