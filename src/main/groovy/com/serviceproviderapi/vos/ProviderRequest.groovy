package com.serviceproviderapi.vos

import javax.validation.constraints.NotNull


class ProviderRequest {

    @NotNull
    String id


    String name


    String email


    String phone


    String fax
}
