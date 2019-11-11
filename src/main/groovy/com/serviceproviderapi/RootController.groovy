package com.serviceproviderapi

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {

    @RequestMapping(value = '', method = RequestMethod.GET)
    String index() {
        return '<-----Greetings from Service Provider Api----->'
    }
}
