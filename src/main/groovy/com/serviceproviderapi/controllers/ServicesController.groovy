package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.services.v1.ServicesService
import com.serviceproviderapi.vos.ServiceRequest
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
@RequestMapping(value = '/v1/{providerId}/services')
class ServicesController {

    @Autowired
    ServicesService servicesService

    //create service
    @RequestMapping(value = '/create', method = RequestMethod.POST)
    ResponseEntity<List<Services>> createProviderService(@RequestBody ServiceRequest serviceRequest, @PathVariable String providerId) {
        new ResponseEntity<List<Services>>(servicesService.createService(providerId,serviceRequest), HttpStatus.CREATED)
    }

    //get single service
    @RequestMapping(value = '/{serviceId}', method = RequestMethod.GET)
    ResponseEntity<Services> getService(@PathVariable String serviceId) {
        new ResponseEntity<Services>(servicesService.getService(serviceId), HttpStatus.OK)
    }

    //get all services
    @RequestMapping(value = '/allservices', method = RequestMethod.GET)
    ResponseEntity<List<Services>> getAllServices(@PathVariable String provider_id) {
        new ResponseEntity<List<Services>>(servicesService.getAllServices(provider_id), HttpStatus.OK)
    }

    //update specific service
    @RequestMapping(value = '/update', method = RequestMethod.PUT)
    ResponseEntity<Services> updateService(@RequestBody ServiceRequest serviceRequest) {
        new ResponseEntity<Services>(servicesService.updateService(serviceRequest), HttpStatus.OK)
    }

    //delete a service
    @RequestMapping(value = '/{serviceId}', method = RequestMethod.DELETE)
    ResponseEntity deleteService(@PathVariable String serviceId) {
        new ResponseEntity(servicesService.deleteServices(serviceId), HttpStatus.OK)
    }
}
