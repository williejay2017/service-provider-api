package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Provider
import com.serviceproviderapi.entities.ProviderServices
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
@RequestMapping(value = '/v1/provider/{organizationId}/{providerId}')
class ProviderController {

    @Autowired
    ProviderService providerService

    //create provider
    @RequestMapping(value = '/create/{id}/{name}/{email}/{phone}/{fax}', method = RequestMethod.POST)
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
    @RequestMapping(value = '/findsingle/{id}', method = RequestMethod.GET)
    ResponseEntity<Provider> getProvider(@PathVariable String organizationId, @PathVariable String id) {
        new ResponseEntity<Provider>(providerService.getProvider(id,organizationId), HttpStatus.OK)
    }

    //get all providers
    @RequestMapping(value = '/findall', method = RequestMethod.GET)
    ResponseEntity<Provider> getAllProvider(@PathVariable String organizationId) {
        new ResponseEntity(providerService.getAllProviders(organizationId), HttpStatus.OK)
    }

    //update provider
    @RequestMapping(value = '/update/{id}/{name}/{email}/{phone}/{fax}', method = RequestMethod.PUT)
    ResponseEntity<Provider> updateProvider(@PathVariable String id,
                                            @PathVariable String name,
                                            @PathVariable String organizationId,
                                            @PathVariable String email,
                                            @PathVariable String phone,
                                            @PathVariable String fax)
    {
        new ResponseEntity<Provider>(providerService.updateProvider(id, organizationId, name, email,phone,fax), HttpStatus.OK)
    }


    //delete single provider
    @RequestMapping(value = '/delete/{providerId}', method = RequestMethod.DELETE)
    ResponseEntity deleteProvider(@PathVariable String providerId, @PathVariable String organizationId
    ) {
        new ResponseEntity(providerService.deleteProvider(providerId, organizationId), HttpStatus.NO_CONTENT)
    }

    //create service
    @RequestMapping(value = '/create/{serviceId}/{serviceName}/{serviceType}', method = RequestMethod.POST)
    ResponseEntity<ProviderServices> createProviderService(@PathVariable String providerId, String serviceId, String serviceName, String serviceType) {
        new ResponseEntity<ProviderServices>(providerService.createService(serviceId,providerId,serviceName,serviceType), HttpStatus.CREATED)
    }

    //get single service
    @RequestMapping(value = '/service/{serviceId}', method = RequestMethod.GET)
    ResponseEntity<ProviderServices> getService(@PathVariable String serviceId) {
        new ResponseEntity<ProviderServices>(providerService.getService(serviceId), HttpStatus.OK)
    }

    //get all services
    @RequestMapping(value = '/allservices', method = RequestMethod.GET)
    ResponseEntity<List<ProviderServices>> getAllServices(@PathVariable String provider_id) {
        new ResponseEntity<List<ProviderServices>>(providerService.getAllServices(provider_id), HttpStatus.OK)
    }

    //delete a service
    @RequestMapping(value = '/delete/{serviceId}', method = RequestMethod.DELETE)
    ResponseEntity deleteService(@PathVariable String serviceId) {
        new ResponseEntity(providerService.deleteService(serviceId), HttpStatus.OK)
    }
}
