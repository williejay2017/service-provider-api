package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Ethnicity
import org.springframework.data.jpa.repository.JpaRepository

interface EthnicityRepository extends JpaRepository<Ethnicity, Long> {
}