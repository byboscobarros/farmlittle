package org.acme.core.adapter.services.mapper

import org.acme.core.model.Species
import java.util.*

interface IBreedResponseDTO : IBaseResponseDTO {
    val id: UUID?
    var name: String?
    var species: ISpeciesResponseDTO?
}