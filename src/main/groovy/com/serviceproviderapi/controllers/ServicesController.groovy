package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.services.v1.ServicesService
import com.serviceproviderapi.vos.ServiceRequest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
@RequestMapping(value = ['/v1/{providerId}', '/services'])
class ServicesController {

    @Autowired
    ServicesService servicesService

    //create service
    @CrossOrigin
    @RequestMapping(value = '/create', method = RequestMethod.POST)
    ResponseEntity<Services> createProviderService(@RequestBody ServiceRequest serviceRequest , @PathVariable('providerId') String providerId) {
        new ResponseEntity<Services>(servicesService.createService(serviceRequest, providerId), HttpStatus.CREATED)
    }

    //get single service
    @CrossOrigin
    @RequestMapping(value = '/{serviceName}', method = RequestMethod.GET)
    ResponseEntity<Services> getService(@PathVariable('serviceName') String serviceName) {
        new ResponseEntity<Services>(servicesService.getService(serviceName), HttpStatus.OK)
    }

    //get all services
    @CrossOrigin
    @RequestMapping(value = '/allservices', method = RequestMethod.GET)
    ResponseEntity<List<Services>> getAllServices(@PathVariable('providerId') String providerId) {
        new ResponseEntity<List<Services>>(servicesService.getAllServices(providerId), HttpStatus.OK)
    }

    //update specific service
    @CrossOrigin
    @RequestMapping(value = '/update', method = RequestMethod.PUT)
    ResponseEntity<Services> updateService(@RequestBody ServiceRequest serviceRequest) {
        new ResponseEntity<Services>(servicesService.updateService(serviceRequest), HttpStatus.OK)
    }

    //delete a service
    @CrossOrigin
    @RequestMapping(value = '/{serviceName}', method = RequestMethod.DELETE)
    ResponseEntity deleteService(@PathVariable('serviceName') String serviceName) {
        new ResponseEntity(servicesService.deleteServices(serviceName), HttpStatus.OK)
    }

    //retrieve a list of services given challenges
    @CrossOrigin
    @RequestMapping(value = '/retrieve', method = RequestMethod.POST)
    ResponseEntity<List<Services>> getServicesAssociateWithChallenges(@RequestBody List<String> challengeIds) {
        new ResponseEntity<List<Services>>(servicesService.getServicesAssociateToChallenge(challengeIds), HttpStatus.ACCEPTED)
    }
}
