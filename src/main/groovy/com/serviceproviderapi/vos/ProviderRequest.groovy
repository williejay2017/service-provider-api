package com.serviceproviderapi.vos

import javax.validation.constraints.NotNull


class ProviderRequest {

    @NotNull
    String id

    @NotNull
    String name

    @NotNull
    String email

    @NotNull
    String phone

    @NotNull
    String fax
}
