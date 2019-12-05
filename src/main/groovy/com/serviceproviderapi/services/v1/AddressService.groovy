package com.serviceproviderapi.services.v1

import com.serviceproviderapi.Exceptions.BadRequestException
import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Services
import com.serviceproviderapi.repositories.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class AddressService {

    @Autowired
    AddressRepository addressRepository

    @Autowired
    ServicesService servicesService

    Address saveAddress(Address address) {
        addressRepository.save(address)
    }

    void createAddress(Address address, Services services) {
        Address newAddress = new Address(
                street: address.street,
                city: address.city,
                state: address.state,
                zipCode: address.zipCode,
                serviceId: services
        )

        if (!addressRepository.findById(newAddress.id)) {
            saveAddress(newAddress)
        }
    }

    void addAddressToService(List<Address> addressList, Services services) {
        for (address in addressList) {
            createAddress(address, services)
        }
    }

    void addAddressToService(Address address, int serviceId) {
        Services services1 = servicesService.getService(serviceId)
        Address addressCheck = services1.addresses.find { target -> target.id == address.id }
        if (addressCheck) {
            throw new BadRequestException(message: 'Address already exist', status: HttpStatus.FOUND)
        }
        createAddress(address, services1)
    }

    void updateServiceAddress(Address newAddress, int serviceId, int addressId) {
        Services services = servicesService.getService(serviceId)
        Address updateAddress = services.addresses.find { target -> target.id == addressId }

        if (!updateAddress) {
            throw new BadRequestException(message: 'address not found', status: HttpStatus.NOT_FOUND)
        }

        updateAddress.street = newAddress.street
        updateAddress.state = newAddress.state
        updateAddress.zipCode = newAddress.zipCode
        updateAddress.city = newAddress.city

        saveAddress(updateAddress)
    }

    void deleteAddress(Address address) {
        addressRepository.delete(address)
    }

}
