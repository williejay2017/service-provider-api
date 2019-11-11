package com.serviceproviderapi.entities

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Transient

@Entity
@Table(name = 'address')
class Address implements Serializable {


    @Id @GeneratedValue
    @Column(name = 'id')
    int id

    @Column(name='street')
    String street


    @Column(name='city')
    String city


    @Column(name='state')
    String state


    @Column(name='zip_code')
    String zipCode

    //fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    @JsonIgnore
    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = 'service_id')
    Services serviceId

}
