package com.serviceproviderapi.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = 'organization')
class Organization {
    @Id
    @Column(name = 'organization_id')
    String id

    @Column(name='name')
    String name

    @Column(name='contact_name')
    String contactName

    @Column(name='contact_email')
    String contactEmail

    @OneToMany(mappedBy = "organization",
        cascade = CascadeType.ALL,
        orphanRemoval = true, targetEntity = Provider.class)
    List<Provider> providers

    List<Provider> getProviders() {
        return providers
    }

    void setProviders(List<Provider> providers) {
        this.providers = providers
    }
}
