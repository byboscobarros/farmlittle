package org.acme.core.adapter.incoming.rest.v1.exception

import jakarta.validation.ConstraintViolationException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class ValidationExceptionMapper : ExceptionMapper<ConstraintViolationException> {

    override fun toResponse(exception: ConstraintViolationException): Response {
        // Mapear as violação de restrição para uma lista de mensagens
        val violations = exception.constraintViolations.map { it.message }
        val errorResponse = ErrorResponse("Validation failed", violations)

        // Retornar uma resposta 400 com a estrutura de erro
        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build()
    }
}

data class ErrorResponse(val message: String, val details: List<String>)