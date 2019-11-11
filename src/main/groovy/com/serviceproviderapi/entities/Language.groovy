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
class Language implements Serializable{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'service_id', insertable =true, updatable =true)
    Services serviceId

    @Id
    @Column(name='language')
    String language

}
