package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.services.v1.ProviderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
@RequestMapping(value = '/v1/provider/{organizationId}/')
class ProviderController {

    @Autowired
    ProviderService providerService

    //create provider
    @RequestMapping(value = 'create/{id}/{name}/{email}/{phone}/{fax}', method = RequestMethod.POST)
    ResponseEntity<Provider> createProvider(@PathVariable String id,
                                            @PathVariable String organizationId,
                                            @PathVariable String name,
                                            @PathVariable String email,
                                            @PathVariable String phone,
                                            @PathVariable String fax)
    {
        new ResponseEntity<Provider>(providerService.createProvider(id, organizationId, name, email,phone,fax), HttpStatus.CREATED)
    }

    //get single provider
    @RequestMapping(value = 'findsingle', method = RequestMethod.GET)
    ResponseEntity<Provider> getProvider(@PathVariable String organizationId) {
        new ResponseEntity<Provider>(providerService.getProvider(organizationId), HttpStatus.OK)
    }

    //get all providers
    @RequestMapping(value = 'findall', method = RequestMethod.GET)
    ResponseEntity<Provider> getAllProvider(@PathVariable String organizationId) {
        new ResponseEntity(providerService.getAllProviders(organizationId), HttpStatus.OK)
    }

    //update provider
    @RequestMapping(value = 'update/{id}/{name}/{email}/{phone}/{fax}', method = RequestMethod.PUT)
    ResponseEntity<Provider> updateProvider(@PathVariable String id,
                                            @PathVariable String name,
                                            @PathVariable String email,
                                            @PathVariable String phone,
                                            @PathVariable String fax)
    {
        new ResponseEntity<Provider>(providerService.updateProvider(id, name, email,phone,fax), HttpStatus.OK)
    }


    //delete single provider
    @RequestMapping(value = 'delete/{providerId}', method = RequestMethod.DELETE)
    ResponseEntity deleteProvider(@PathVariable String providerId) {
        new ResponseEntity(providerService.deleteProvider(providerId), HttpStatus.NO_CONTENT)
    }

    //delete all providers
    @RequestMapping(value = 'purge', method = RequestMethod.DELETE)
    ResponseEntity deleteAllProviders(@PathVariable String organizationId) {
        new ResponseEntity(providerService.deleteAllProviders(organizationId), HttpStatus.NO_CONTENT)
    }

}
