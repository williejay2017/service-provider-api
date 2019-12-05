package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.services.v1.ServicesService
import com.serviceproviderapi.vos.ServiceRequest
import com.serviceproviderapi.vos.UpdateServicesRequest
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
    ResponseEntity<Services> createProviderService(@RequestBody ServiceRequest serviceRequest, @PathVariable('providerId') String providerId) {
        new ResponseEntity<Services>(servicesService.createService(serviceRequest, providerId), HttpStatus.CREATED)
    }

    //get single service
    @CrossOrigin
    @RequestMapping(value = '/{serviceId}', method = RequestMethod.GET)
    ResponseEntity<Services> getService(@PathVariable('serviceId') int serviceId) {
        new ResponseEntity<Services>(servicesService.getService(serviceId), HttpStatus.OK)
    }

    //get all services
    @CrossOrigin
    @RequestMapping(value = '/allservices', method = RequestMethod.GET)
    ResponseEntity<List<Services>> getAllServices(@PathVariable('providerId') String providerId) {
        new ResponseEntity<List<Services>>(servicesService.getAllServices(providerId), HttpStatus.OK)
    }

    //delete a service
    @CrossOrigin
    @RequestMapping(value = '/{serviceId}', method = RequestMethod.DELETE)
    ResponseEntity deleteService(@PathVariable('serviceId') int serviceId) {
        new ResponseEntity(servicesService.deleteServices(serviceId), HttpStatus.OK)
    }

    //retrieve a list of services given challenges
    @CrossOrigin
    @RequestMapping(value = '/retrieve', method = RequestMethod.POST)
    ResponseEntity<List<Services>> getServicesAssociateWithChallenges(@RequestBody List<String> challengeIds) {
        new ResponseEntity<List<Services>>(servicesService.getServicesAssociateToChallenge(challengeIds), HttpStatus.ACCEPTED)
    }

    //update service name , type, address
    @CrossOrigin
    @RequestMapping(value = '/updates/{serviceId}', method = RequestMethod.PUT)
    ResponseEntity<?> updateServiceAttributes(@PathVariable('serviceId') int serviceId, @RequestBody UpdateServicesRequest updateServicesRequest) {
        new ResponseEntity<Services>(servicesService.updateService(updateServicesRequest, serviceId), HttpStatus.ACCEPTED)
    }

    //add geo , lang, eth to existing services
    @CrossOrigin
    @RequestMapping(value = '/existingService/{serviceId}', method = RequestMethod.POST)
    ResponseEntity<?> createOnExistingService(@PathVariable('serviceId') int serviceId, @RequestBody UpdateServicesRequest updateServicesRequest) {
        new ResponseEntity<?>(servicesService.addToExistingService(updateServicesRequest, serviceId), HttpStatus.ACCEPTED)
    }

}
