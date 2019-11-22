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
}
