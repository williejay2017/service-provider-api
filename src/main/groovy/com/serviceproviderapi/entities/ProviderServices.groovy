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

    @Column(name='service_name')
    String name

    @Column(name='service_type')
    String type

    @OneToMany(mappedBy = 'serviceId', orphanRemoval = true, targetEntity = Address.class)
    List<Address> addresses

    @OneToMany(mappedBy = 'serviceId', orphanRemoval = true, targetEntity = Ethnicity.class)
    List<Ethnicity> ethnicities

    @OneToMany(mappedBy = 'serviceId', orphanRemoval = true, targetEntity = Geometry.class)
    List<Geometry> geometries

    @OneToMany(mappedBy = 'serviceId', orphanRemoval = true, targetEntity = Language.class)
    List<Language> languages

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'provider_id', insertable =true, updatable =true)
    Provider provider

    Provider getProvider() {
        return provider
    }

    void setProvider(Provider provider) {
        this.provider = provider
    }


}
