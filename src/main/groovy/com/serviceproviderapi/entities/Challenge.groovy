package com.serviceproviderapi.entities

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = 'challenge')
class Challenge implements Serializable{

    @Id @GeneratedValue
    @Column(name = 'id')
    int id

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'service_id', insertable =true, updatable =true)
    Services serviceId

    @Column(name = 'challenge_id')
    String challengeId

}
