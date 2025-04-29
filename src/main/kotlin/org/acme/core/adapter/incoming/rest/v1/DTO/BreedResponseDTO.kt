package org.acme.core.adapter.incoming.rest.v1.DTO

import org.acme.core.adapter.services.mapper.IBreedResponseDTO
import org.acme.core.adapter.services.mapper.ISpeciesResponseDTO
import org.acme.core.model.Species
import java.time.ZonedDateTime
import java.util.*

data class BreedResponseDTO(
    override val id: UUID?,
    override var name: String,
    override var species: ISpeciesResponseDTO?,
    override var createdAt: ZonedDateTime?,
    override var updatedAt: ZonedDateTime?
) : IBreedResponseDTO