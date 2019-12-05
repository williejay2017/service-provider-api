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
@Table(name='ethnicities')
class Ethnicity implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = 'id')
    int id

    @JsonIgnore
    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = 'service_id')
    Services serviceId

    @Column(name='ethnic_type')
    String type

}
