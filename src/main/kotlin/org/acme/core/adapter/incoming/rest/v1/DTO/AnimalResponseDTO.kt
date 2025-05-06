package org.acme.core.adapter.incoming.rest.v1.DTO

import org.acme.core.adapter.services.mapper.IAnimalResponseDTO
import org.acme.core.adapter.services.mapper.IBreedResponseDTO
import org.acme.core.adapter.services.mapper.ISpeciesResponseDTO
import org.acme.core.model.AnimalGender
import java.time.ZonedDateTime
import java.util.*

data class AnimalResponseDTO(
    override val id: UUID?,
    override var name: String?,
    override var dob: Date?,
    override var approximateAge: Boolean,
    override var species: ISpeciesResponseDTO?,
    override var breed: IBreedResponseDTO?,
    override var createdAt: ZonedDateTime?,
    override var updatedAt: ZonedDateTime?,
    override var gender: AnimalGender?
) : IAnimalResponseDTO