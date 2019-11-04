package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name='geometries')
class Geometry {

    @Id
    @Column(name='geometrie_id', unique= true, nullable = false)
    String id

    @Column(name='geometrie_service_id')
    String serviceId

    @Column(name='geometry')
    List<String> geometries


}
