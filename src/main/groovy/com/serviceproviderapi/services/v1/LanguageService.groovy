package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Language
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.LanguageRepository
import org.springframework.beans.factory.annotation.Autowired
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
        for(language in languageList){
            createLanguage(language, services)
        }
    }

    void addLanguageToService(List<Language> languageList, String serviceName) {
        Services services1 = servicesService.getService(serviceName)
        addLanguageToService(languageList, services1)
    }

}
