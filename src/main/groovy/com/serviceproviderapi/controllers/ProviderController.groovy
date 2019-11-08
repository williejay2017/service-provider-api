package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.services.v1.ProviderService
import com.serviceproviderapi.vos.ProviderRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
@RequestMapping(value = ['/{providerId}', '/provider'])
class ProviderController {

    @Autowired
    ProviderService providerService

    //create provider
    @RequestMapping(value = '/create', method = RequestMethod.POST)
    ResponseEntity<Provider> createProvider(@RequestBody ProviderRequest providerRequest)
    {
        new ResponseEntity<Provider>(providerService.createProvider(providerRequest), HttpStatus.CREATED)
    }

    //get single provider
    @RequestMapping(value = '/find', method = RequestMethod.GET)
    ResponseEntity<Provider> getProvider(@PathVariable String providerId) {
        new ResponseEntity<Provider>(providerService.getProvider(providerId), HttpStatus.OK)
    }

    //update provider
    @RequestMapping(value = '/update', method = RequestMethod.PUT)
    ResponseEntity<Provider> updateProvider(@RequestBody ProviderRequest providerRequest)
    {
        new ResponseEntity<Provider>(providerService.updateProvider(providerRequest), HttpStatus.OK)
    }


    //delete single provider
    @RequestMapping(value = '', method = RequestMethod.DELETE)
    ResponseEntity deleteProvider(@PathVariable String providerId
    ) {
        new ResponseEntity(providerService.deleteProvider(providerId), HttpStatus.NO_CONTENT)
    }
}
