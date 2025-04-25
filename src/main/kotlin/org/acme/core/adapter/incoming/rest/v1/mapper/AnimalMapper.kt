package org.acme.core.adapter.incoming.rest.v1.mapper

import jakarta.enterprise.context.ApplicationScoped
import org.acme.core.adapter.incoming.rest.v1.DTO.AnimalRequestDTO
import org.acme.core.model.Animal
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.`in`.ISpeciesService
import java.time.ZonedDateTime
import java.util.*

@ApplicationScoped
class AnimalMapper (
    private val speciesService: ISpeciesService,
    private val breedService: IBreedService
) {
    fun fromDto(dto: AnimalRequestDTO): Animal {
        val species = speciesService.getSpeciesById(dto.speciesId)
            ?: throw IllegalArgumentException("Species not found with id: ${dto.speciesId}")
        val breed = breedService.getBreedById(dto.breedId)
            ?: throw IllegalArgumentException("Breed not found with id: ${dto.breedId}")

        return Animal(
            id = UUID.randomUUID(),
            name = dto.name,
            dob = dto.dob,
            aproximateAge = dto.aproximateAge,
            gender = dto.gender,
            species = species,
            breed = breed,
            createdAt = ZonedDateTime.now(),
            updatedAt = ZonedDateTime.now()
        )
    }
}