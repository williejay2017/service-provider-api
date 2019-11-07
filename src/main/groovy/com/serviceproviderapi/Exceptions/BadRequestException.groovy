package com.serviceproviderapi.Exceptions

import org.springframework.http.HttpStatus

class BadRequestException extends RuntimeException {

    String message
    HttpStatus status

    BadRequestException(
            String message = 'Something went wrong with the request',
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR
    ) {
        super(message)
        setMessage(message)
        setStatus(status)
    }

}
