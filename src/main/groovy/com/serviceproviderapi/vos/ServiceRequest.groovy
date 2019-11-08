package com.serviceproviderapi.vos


import javax.validation.constraints.NotNull

class ServiceRequest {

    @NotNull
    String id

    @NotNull
    String name

    @NotNull
    String type

}
