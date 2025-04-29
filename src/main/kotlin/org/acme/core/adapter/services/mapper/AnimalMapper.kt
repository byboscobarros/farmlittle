package org.acme.core.adapter.services.mapper

import org.acme.core.adapter.services.BreedService
import org.acme.core.adapter.services.SpeciesService
import org.acme.core.adapter.incoming.rest.v1.DTO.SpeciesResponseDTO
import org.acme.core.model.Animal
import org.acme.core.model.AnimalGender
import java.time.ZonedDateTime
import java.util.*

class AnimalMapper(
    private val speciesService: SpeciesService,
    private val breedService: BreedService,
    private val breedMapper: BreedMapper,
    private val speciesMapper: SpeciesMapper
) {
    fun toEntity(dto: IAnimalRequestDTO): Animal {
        return Animal(
            id = dto.id,
            name = dto.name,
            species = speciesService.getSpeciesById(dto.speciesId),
            breed = breedService.getBreedById(dto.breedId),
            createdAt = null,
            updatedAt = null,
            dob = dto.dob,
            approximateAge = dto.approximateAge,
            gender = AnimalGender.valueOf(dto.gender)
        )
    }

    fun toDto(entity: Animal) : IAnimalResponseDTO {
        return object : IAnimalResponseDTO {
            override val id: UUID? = entity.id
            override var name: String = entity.name
            override var dob: Date? = entity.dob
            override var approximateAge: Boolean = entity.approximateAge?: false
            override var species: ISpeciesResponseDTO? = entity.species?.let { species ->
                speciesMapper.toDto(species)
            }
            override var breed: IBreedResponseDTO? = entity.breed?.let { breed ->
                breedMapper.toDto(breed)
            }
            override var createdAt: ZonedDateTime? = entity.createdAt
            override var updatedAt: ZonedDateTime? = entity.updatedAt
        }
    }
}