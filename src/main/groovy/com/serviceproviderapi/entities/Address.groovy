package com.serviceproviderapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = 'address')
class Address implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'service_id', insertable =true, updatable =true)
    ProviderServices serviceId

    @Column(name='street')
    String street

    @Column(name='city')
    String city

    @Column(name='state')
    String state

    @Column(name='zip_code')
    String zipCode

}
