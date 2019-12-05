package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Language
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.LanguageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class LanguageService {

    @Autowired
    LanguageRepository languageRepository

    @Autowired
    ServicesService servicesService

    void saveLanguage(Language language) {
        languageRepository.save(language)
    }

    private createLanguage(Language language, Services services) {
        Language language1 = new Language(
                language: language.language,
                serviceId: services
        )
        saveLanguage(language1)
    }

    void addLanguageToService(List<Language> languageList, Services services) {
        for (language in languageList) {
            createLanguage(language, services)
        }
    }

    void addLanguageToService(Language language, int serviceId) {
        Services services = servicesService.getService(serviceId)
        Language languageCheck = services.languages.find { target -> target.language == language.language }
        if (languageCheck) {
            throw new BadRequestException(message: 'language already exist', status: HttpStatus.FOUND)
        }
        createLanguage(language, services)
    }

    void deleteLanguageFromService(Language language) {
        languageRepository.delete(language)
    }

}
