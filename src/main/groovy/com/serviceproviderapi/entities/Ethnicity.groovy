package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name='ethnicities')
class Ethnicity {
    @Id
    @Column(name='ethnicity_id', unique= true, nullable = false)
    String id

    @Column(name='ethnic_type')
    String type

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'service_id', insertable =true, updatable =true)
    Services serviceId

}
