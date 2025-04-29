package org.acme.core.adapter.services.mapper

import java.util.*

interface IBreedRequestDTO {
    val id: UUID?
    var name: String
    var speciesId: UUID
}