package org.acme.core.adapter.services.mapper

import org.acme.core.model.AnimalGender
import java.util.*

interface IAnimalResponseDTO : IBaseResponseDTO {
    val id: UUID?
    var name: String?
    var dob: Date?
    var approximateAge: Boolean
    var species: ISpeciesResponseDTO?
    var breed: IBreedResponseDTO?
    var gender: AnimalGender?
}