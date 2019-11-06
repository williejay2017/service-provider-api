package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name='service')
class ProviderServices {
    @Id
    @Column(name='service_id', unique = true, nullable = false)
    String id

    @Column(name='provider_id')
    String providerId

    @Column(name='service_name')
    String name

    @Column(name='service_type')
    String type

    @OneToMany(mappedBy = 'service_id', orphanRemoval = true)
    List<Address> addresses

    @OneToMany(mappedBy = 'service_id', orphanRemoval = true)
    List<Ethnicity> ethnicities

    @OneToMany(mappedBy = 'service_id', orphanRemoval = true)
    List<Geometry> geometries

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'provider_id')
    Provider provider

}
