package org.acme.core.adapter.services

import jakarta.enterprise.context.ApplicationScoped
import org.acme.core.adapter.database.AnimalRepository
import org.acme.core.model.Animal
import org.acme.core.port.`in`.IAnimalService
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.out.IAnimalRepository
import java.util.*

@ApplicationScoped
class AnimalService(
    private val animalRepository: IAnimalRepository,
    private val breedService: IBreedService
) : IAnimalService {
    override fun getAllAnimals(): List<Animal> {
        return animalRepository.listAllAnimals()
    }

    override fun getAnimalById(id: UUID): Animal? {
        return animalRepository.findById(id)
    }

    override fun saveAnimal(animal: Animal): Animal {
        return animalRepository.save(animal)
    }

    override fun deleteAnimalById(id: UUID) {
        animalRepository.deleteById(id)
    }
}