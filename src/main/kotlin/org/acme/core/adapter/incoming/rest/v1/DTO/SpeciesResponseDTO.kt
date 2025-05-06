package org.acme.core.adapter.incoming.rest.v1.DTO

import jakarta.enterprise.context.ApplicationScoped
import org.acme.core.adapter.services.mapper.ISpeciesResponseDTO
import java.time.ZonedDateTime
import java.util.*


data class SpeciesResponseDTO(
    override val id: UUID,
    override var name: String?,
    override var createdAt: ZonedDateTime?,
    override var updatedAt: ZonedDateTime?
) : ISpeciesResponseDTO