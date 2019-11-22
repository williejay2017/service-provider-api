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
@Table(name = 'challenge')
class Challenge implements Serializable{


    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = 'id', columnDefinition="text")
    int id

    @JsonIgnore
    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = 'serviceId')
    Services serviceId

    @Column(name = 'challenge_id')
    String challengeId
}
