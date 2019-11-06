package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name='languages')
class Language {

    @Id
    @Column(name='language_id', unique= true, nullable = false)
    String id

    @Column(name='language')
    String language

    @Column(name='language_service_id')
    String serviceId

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'service_id')
    ProviderServices service
}
