package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Challenge
import org.springframework.data.jpa.repository.JpaRepository

interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}