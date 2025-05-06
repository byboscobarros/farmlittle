package org.acme.core.adapter.incoming.rest.v1.DTO

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.acme.core.adapter.services.mapper.IBreedRequestDTO
import java.util.*

data class BreedRequestDTO (
    override val id: UUID? = null,

    @field:NotEmpty(message = "Name is required")
    @field:NotNull(message = "Name is required")
    @field:Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    override var name: String?,

    @field:NotNull(message = "Species ID is required")
    override var speciesId: UUID?
) : IBreedRequestDTO