package org.acme.core.port.`in`

import org.acme.core.model.Species
import java.util.*

interface ISpeciesService {
    fun getAllSpecies(): List<Species>
    fun getSpeciesById(id: UUID?): Species?
    fun saveSpecies(species: Species): Species
    fun updateSpecies(id: UUID, updatedSpecies: Species): Species?
    fun deleteSpeciesById(id: UUID)
}