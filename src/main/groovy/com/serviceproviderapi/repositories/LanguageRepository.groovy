package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Language
import org.springframework.data.jpa.repository.JpaRepository

interface LanguageRepository extends JpaRepository<Language, Long> {
}