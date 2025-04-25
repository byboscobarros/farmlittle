package org.acme.core.adapter.incoming.rest.v1.DTO

import org.acme.core.model.AnimalGender
import java.util.*

data class AnimalRequestDTO(
    val name: String,
    val dob: Date,
    val aproximateAge: Boolean,
    val gender: AnimalGender,
    val speciesId: UUID,
    val breedId: UUID
)