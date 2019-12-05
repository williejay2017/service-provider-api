package com.serviceproviderapi.entities

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = 'address')
class Address implements Serializable {


    @Id @GeneratedValue(strategy= GenerationType.AUTO)
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

    @JsonIgnore
    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = 'service_id')
    Services serviceId

}
