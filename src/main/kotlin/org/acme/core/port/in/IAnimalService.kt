package org.acme.core.port.`in`

import org.acme.core.model.Animal
import java.util.*

interface IAnimalService {
    fun getAllAnimals(): List<Animal>
    fun getAnimalById(id: UUID): Animal?
    fun saveAnimal(animal: Animal): Animal
    fun deleteAnimalById(id: UUID)
    fun updateAnimal(id: UUID, updatedAnimal: Animal): Animal?
}