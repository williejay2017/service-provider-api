package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Organization
import com.serviceproviderapi.services.v1.OrganizationService
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
@RequestMapping('/v1/organizations')
class OrganizationController {

    @Autowired
    OrganizationService organizationService

    //create org
    @RequestMapping(value = '/create/{id}/{name}/{contactName}/{contactEmail}', method = RequestMethod.POST)
    ResponseEntity<Organization> createOrganization(@PathVariable String id,
                                                    @PathVariable String name,
                                                    @PathVariable String contactName,
                                                    @PathVariable String contactEmail
    ) {
        new ResponseEntity(organizationService.createOrganization(id,name,contactName,contactEmail), HttpStatus.CREATED)
    }

    //get organization
    @RequestMapping(value = '/get/{organizationId}', method = RequestMethod.GET)
    ResponseEntity<Organization> getOrganization(@PathVariable String organizationId) {
        new ResponseEntity<Organization>(organizationService.findOrganization(organizationId), HttpStatus.OK)
    }

    //delete org
    @RequestMapping(value = '/delete/{id}', method = RequestMethod.DELETE)
    ResponseEntity deleteOrganization(@PathVariable String id) {
        new ResponseEntity(organizationService.deleteOrganization(id), HttpStatus.NO_CONTENT)
    }

    //update org
    @RequestMapping(value = '/update/{organizationId}', method = RequestMethod.PUT)
    ResponseEntity<Organization> updateOrg(@PathVariable String organizationId,
                                           @PathVariable String name,
                                           @PathVariable String contactName,
                                           @PathVariable String contactEmail
    ) {
        new ResponseEntity<Organization>(organizationService.updateOrganization(organizationId,name,contactName,contactEmail), HttpStatus.OK)
    }

}
