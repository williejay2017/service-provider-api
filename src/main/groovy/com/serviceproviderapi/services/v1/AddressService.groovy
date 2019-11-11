package com.serviceproviderapi.services.v1

import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressService {

    @Autowired
    AddressRepository addressRepository

    Address saveAddress (Address address) {
        addressRepository.save(address)
    }

    void createAddress (Address address, Services services) {
        Address newAddress = new Address(
                street: address.street,
                city: address.city,
                state: address.state,
                zipCode: address.zipCode,
                serviceId: services
        )
        if(!addressRepository.findById(newAddress.id)) {
            saveAddress(newAddress)
        }
    }
}
