package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Challenge
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.ChallengeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository

    @Autowired
    ServicesService servicesService

    void saveChallenge (Challenge challenge) {
        challengeRepository.save(challenge)
    }

    void createChallenge(Services services , String challengeId) {
        Challenge challenge = new Challenge(
                challengeId: challengeId,
                serviceId: services
        )
        saveChallenge(challenge)
    }

    void addChallengeToService(List<Challenge> challengeList, Services services) {
        for(challenge in challengeList){
            createChallenge(services, challenge.challengeId)
        }
    }

    void addChallengeToService(List<Challenge> challengeList, String serviceName) {
        Services services1 = servicesService.getService(serviceName)
        addChallengeToService(challengeList, services1)
    }
}
