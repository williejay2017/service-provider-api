package com.serviceproviderapi.controllers

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@EnableAutoConfiguration
@RestController
@RequestMapping(value = '/v1/provider/{organizationId}/')
class ServiceController {
}
