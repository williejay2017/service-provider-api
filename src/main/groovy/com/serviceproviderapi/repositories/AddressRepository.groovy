package com.serviceproviderapi.repositories

import com.serviceproviderapi.entities.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(int id)
    void deleteById(int id)
}