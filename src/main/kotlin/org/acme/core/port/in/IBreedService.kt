package org.acme.core.port.`in`

import org.acme.core.model.Breed
import java.util.*

interface IBreedService {
    fun getAllBreeds(): List<Breed>
    fun getBreedById(id: UUID): Breed?
    fun saveBreed(breed: Breed): Breed
    fun deleteBreedById(id: UUID)
}