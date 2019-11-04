package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name='service')
class Service {
    @Id
    @Column(name='service_id', unique = true, nullable = false)
    String id

    @Column(name='provider_id')
    String providerId

    @Column(name='service_name')
    String name

    @Column(name='service_type')
    String type

}
