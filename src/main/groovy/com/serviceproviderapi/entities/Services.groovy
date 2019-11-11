package com.serviceproviderapi.entities

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.CascadeType
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
class Services implements Serializable {
    @Id
    @Column(name='service_id', unique = true, nullable = false)
    String id

    @Column(name='service_name')
    String name

    @Column(name='service_type')
    String type

    @OneToMany(mappedBy = 'serviceId',  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Address> addresses

    @OneToMany(mappedBy = 'serviceId', cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Ethnicity.class)
    List<Ethnicity> ethnicities

    @OneToMany(mappedBy = 'serviceId', cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Geometry.class)
    List<Geometry> geometries

    @OneToMany(mappedBy = 'serviceId', cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Language.class)
    List<Language> languages

    @OneToMany(mappedBy = 'serviceId', cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Challenge.class)
    List<Challenge> challenges

    @JsonIgnore
    @ManyToOne(targetEntity = Provider.class)
    @JoinColumn(name = 'provider_id')
    private Provider provider

}
