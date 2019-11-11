package com.serviceproviderapi.vos

import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Challenge
import com.serviceproviderapi.entities.Ethnicity
import com.serviceproviderapi.entities.Geometry
import com.serviceproviderapi.entities.Language
import jdk.internal.jline.internal.Nullable

import javax.validation.constraints.NotNull

class ServiceRequest {

    @NotNull
    String id

    @NotNull
    String name

    @NotNull
    String type

    @NotNull
    List<Address> address

    @Nullable
    List<Ethnicity> ethnicity

    @Nullable
    List<Language> language

    @Nullable
    List<Geometry> geometry

    @Nullable
    List<Challenge> challenge

}
