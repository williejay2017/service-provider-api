package com.serviceproviderapi.vos

import com.sun.istack.NotNull

class ProviderRequest {

    @NotNull
    String id

    @NotNull
    String name

    String email

    String phone

    String fax
}
