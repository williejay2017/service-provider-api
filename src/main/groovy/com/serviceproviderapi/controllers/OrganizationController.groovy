package com.serviceproviderapi.controllers

import com.serviceproviderapi.entities.Organization
import com.serviceproviderapi.services.v1.OrganizationService
import com.serviceproviderapi.vos.OrganizationRequest
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
@RequestMapping('/v1/organizations')
class OrganizationController {

    @Autowired
    OrganizationService organizationService

    //create org
    @RequestMapping(value = '', method = RequestMethod.POST)
    ResponseEntity<Organization> createOrganization(@RequestBody OrganizationRequest organizationRequest
    ) {
        new ResponseEntity(organizationService.createOrganization(organizationRequest), HttpStatus.CREATED)
    }

    //get organization
    @RequestMapping(value = '/get/{organization_id}', method = RequestMethod.GET)
    ResponseEntity<Organization> getOrganization(@PathVariable String organization_id) {
        new ResponseEntity<Organization>(organizationService.findOrganization(organization_id), HttpStatus.OK)
    }

    //update org
    @RequestMapping(value = '/update/{orgId}', method = RequestMethod.PUT)
    ResponseEntity<Organization> updateOrg(@PathVariable String orgId, @RequestBody OrganizationRequest organizationRequest) {
        new ResponseEntity<Organization>(organizationService.updateOrganization(orgId, organizationRequest), HttpStatus.OK)
    }

}
