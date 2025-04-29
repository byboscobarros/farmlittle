package org.acme.core.adapter.services.mapper

import org.acme.core.adapter.incoming.rest.v1.DTO.BreedResponseDTO
import org.acme.core.adapter.incoming.rest.v1.DTO.SpeciesResponseDTO
import java.util.*

interface IAnimalResponseDTO : IBaseResponseDTO {
    val id: UUID?
    var name: String
    var dob: Date?
    var approximateAge: Boolean
    var species: SpeciesResponseDTO
    var breed: BreedResponseDTO
}