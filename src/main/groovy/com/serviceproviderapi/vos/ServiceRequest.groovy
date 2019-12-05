package com.serviceproviderapi.vos

import com.serviceproviderapi.entities.Address
import com.serviceproviderapi.entities.Challenge
import com.serviceproviderapi.entities.Ethnicity
import com.serviceproviderapi.entities.Language
import org.springframework.data.geo.Point
import org.springframework.data.geo.Polygon
import org.springframework.lang.Nullable


import javax.validation.constraints.NotNull

class ServiceRequest {

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
    List<Point> geometry

    @Nullable
    List<Challenge> challenge

}
