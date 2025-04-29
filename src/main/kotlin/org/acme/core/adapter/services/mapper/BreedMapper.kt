package org.acme.core.adapter.services.mapper

import jakarta.enterprise.context.ApplicationScoped
import org.acme.core.adapter.incoming.rest.v1.DTO.SpeciesResponseDTO
import org.acme.core.model.Breed
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.`in`.ISpeciesService
import java.time.ZonedDateTime
import java.util.*

@ApplicationScoped
class BreedMapper (
    private val speciesService: ISpeciesService,
    private val breedService: IBreedService
) {
    fun toEntity(dto: IBreedRequestDTO): Breed {
        return Breed(
            id = dto.id,
            name = dto.name,
            species = speciesService.getSpeciesById(dto.speciesId),
            createdAt = null,
            updatedAt = null
        )
    }

    fun toDto(entity: Breed): IBreedResponseDTO {
        return object : IBreedResponseDTO {
            override val id: UUID? = entity.id
            override var name: String = entity.name
            override var species: ISpeciesResponseDTO? = entity.species?.let { species ->
                SpeciesResponseDTO(
                    id = species.id!!,
                    name = species.name,
                    createdAt = species.createdAt,
                    updatedAt = species.updatedAt
                )
            }
            override var createdAt: ZonedDateTime? = entity.createdAt
            override var updatedAt: ZonedDateTime? = entity.updatedAt
        }
    }

    fun toDtoList(entities: List<Breed>): List<IBreedResponseDTO> {
        return entities.map { toDto(it) }
    }
}