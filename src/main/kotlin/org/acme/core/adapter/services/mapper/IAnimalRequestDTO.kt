package org.acme.core.adapter.services.mapper

import org.acme.core.model.AnimalGender
import java.util.*

interface IAnimalRequestDTO {
    val id: UUID?
    var name: String?
    var dob: Date?
    var approximateAge: Boolean?
    var gender: String?
    var speciesId: UUID?
    var breedId: UUID?
}