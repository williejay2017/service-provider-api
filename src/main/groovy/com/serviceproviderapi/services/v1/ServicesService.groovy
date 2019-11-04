package com.serviceproviderapi.services.v1

import com.serviceproviderapi.repositories.ServiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServicesService {

    @Autowired
    ServiceRepository serviceRepository
}
