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
@Table(name='provider')
class Provider {

    @Id
    @Column(name = 'provider_id', unique = true, nullable = false)
    String id

    @Column(name='organization_id', nullable = false)
    String organizationId

    @Column(name='provider_name')
    String name

    @Column(name='provider_email')
    String email

    @Column(name='provider_phone')
    String phone

    @Column(name='provider_fax')
    String fax

    @OneToMany(mappedBy = 'provider_id', orphanRemoval = true)
    List<ProviderServices> services

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'organization_id')
    Organization organization

}
