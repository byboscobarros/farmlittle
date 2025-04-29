package org.acme.core.adapter.incoming.rest.v1.exception

import com.fasterxml.jackson.databind.exc.ValueInstantiationException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class ValueInstantiationExceptionMapper : ExceptionMapper<ValueInstantiationException> {

    override fun toResponse(exception: ValueInstantiationException): Response {
        val errorResponse = ErrorResponse(
            message = "Invalid request payload",
            details = listOf(exception.message ?: "Unknown deserialization error")
        )

        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build()
    }
}