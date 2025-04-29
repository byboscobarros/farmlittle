package org.acme.core.adapter.incoming.rest.v1.exception

import com.fasterxml.jackson.databind.JsonMappingException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class JsonMappingExceptionMapper : ExceptionMapper<JsonMappingException> {

    override fun toResponse(exception: JsonMappingException): Response {
        // Logar a exceção para ajudar no diagnóstico
        println("Captured JsonMappingException: ${exception.message}")

        val errorResponse = ErrorResponse(
            message = "Invalid JSON format",
            details = listOf(exception.message ?: "Unknown deserialization error")
        )

        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build()
    }
}