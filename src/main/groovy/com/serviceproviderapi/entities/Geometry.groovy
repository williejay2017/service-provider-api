package com.serviceproviderapi.entities

import org.springframework.data.geo.Polygon

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = 'geometries')
class Geometry implements Serializable {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'service_id', insertable = true, updatable = true)
    Services serviceId

    @Id
    @Column(name = 'geometry')
    Polygon polygon
}
