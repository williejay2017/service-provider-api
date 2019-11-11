package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Challenge
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.ChallengeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository

    Challenge createChallenge(Services services , String challengeId) {
        Challenge challenge = new Challenge(
                challengeId: challengeId,
                serviceId: services
        )
        if(services.challenges.contains(challenge)){
            throw new BadRequestException(message: 'Challenge Exist within this service ', status: HttpStatus.CONFLICT)
        }
        challengeRepository.save(challenge)
        challenge
    }
}
