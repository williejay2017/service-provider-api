package com.serviceproviderapi.vos

import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Challenge
import com.serviceproviderapi.entities.Ethnicity
import com.serviceproviderapi.entities.Language
import org.springframework.data.geo.Point
import org.springframework.lang.Nullable


import javax.validation.constraints.NotNull

class UpdateServicesRequest {

    @Nullable
    String type

    @Nullable
    String name

    @Nullable
    Address address

    @Nullable
    int addressId

    @Nullable
    Ethnicity ethnicity

    @Nullable
    Language language

    @Nullable
    List<Point> geometry

    @Nullable
    Challenge challenge

}


