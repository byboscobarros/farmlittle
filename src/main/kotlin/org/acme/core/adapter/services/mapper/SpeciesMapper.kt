package org.acme.core.adapter.services.mapper

import jakarta.enterprise.context.ApplicationScoped
import org.acme.core.adapter.services.BreedService
import org.acme.core.adapter.services.SpeciesService
import org.acme.core.model.Species
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.`in`.ISpeciesService
import java.time.ZonedDateTime
import java.util.*

@ApplicationScoped
class SpeciesMapper (
    private val speciesService: SpeciesService,
    private val breedService: BreedService
) {
    fun toEntity(dto: ISpeciesRequestDTO): Species {
        return Species(
            id = dto.id,
            name = dto.name,
            breeds = breedService.getBreedsBySpeciesId(dto.id).toMutableList(),
            createdAt = null,
            updatedAt = null
        )
    }

    fun toDto(entity: Species): ISpeciesResponseDTO {
        return object : ISpeciesResponseDTO {
            override val id: UUID? = entity.id
            override var name: String? = entity.name
            override var createdAt: ZonedDateTime? = entity.createdAt
            override var updatedAt: ZonedDateTime? = entity.updatedAt
        }
    }

    fun toDtoList(entities: List<Species>): List<ISpeciesResponseDTO> {
        return entities.map { toDto(it) }
    }
}