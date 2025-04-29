package org.acme.core.adapter.services.mapper

import java.util.UUID

interface ISpeciesResponseDTO : IBaseResponseDTO {
    val id: UUID?
    var name: String
}