package com.serviceproviderapi.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name='provider')
class Provider {

    @Id
    @Column(name = 'provider_id', unique = true, nullable = false)
    String id

    @Column(name='name')
    String name

    @Column(name='email')
    String email

    @Column(name='phone_number')
    String phone

    @Column(name='fax_number')
    String fax

    @OneToMany(mappedBy = 'provider', cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Services> services

}
