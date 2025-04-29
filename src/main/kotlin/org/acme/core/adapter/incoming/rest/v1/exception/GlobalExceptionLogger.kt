package org.acme.core.adapter.incoming.rest.v1.exception

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

//@Provider
class GlobalExceptionLogger : ExceptionMapper<Throwable> {
    override fun toResponse(exception: Throwable): Response {
        exception.printStackTrace() // loga a stack trace completa
        println("Exception lançada: ${exception::class.qualifiedName}")

        // Você ainda pode devolver uma resposta genérica
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(mapOf("error" to "Erro interno"))
            .build()
    }
}