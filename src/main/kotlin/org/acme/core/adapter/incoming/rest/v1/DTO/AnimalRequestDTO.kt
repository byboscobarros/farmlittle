package org.acme.core.adapter.incoming.rest.v1.DTO

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.acme.core.adapter.services.mapper.IAnimalRequestDTO
import java.util.*

data class AnimalRequestDTO(
    override val id: UUID?,

    @field:NotEmpty(message = "Name must not be empty")
    @field:NotNull(message = "Name is required")
    @field:Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    override var name: String?,

    @field:NotNull(message = "dob is required")
    override var dob: Date?,

    @field:NotNull(message = "approxmimated age is required")
    override var approximateAge: Boolean?,

    @field:NotNull(message = "gender is required")
    override var gender: String?,
    override var speciesId: UUID?,
    override var breedId: UUID?
) : IAnimalRequestDTO