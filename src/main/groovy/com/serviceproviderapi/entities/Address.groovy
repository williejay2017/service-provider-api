package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'address')
class Address {

    @Id
    @Column(name='service_id')
    String serviceId

    @Column(name='street')
    String street

    @Column(name='')
    String city

    @Column(name='')
    String state

    @Column(name='')
    String zipCode


}
