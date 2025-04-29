package org.acme.core.adapter.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.core.model.Breed
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.out.IBreedRepository
import java.util.*

@ApplicationScoped
class BreedService(private val breedRepository: IBreedRepository) : IBreedService {
    override fun getAllBreeds(): List<Breed> {
        return breedRepository.findAllBreeds().list()
    }

    override fun getBreedById(id: UUID): Breed? {
        return breedRepository.findById(id)
    }

    override fun saveBreed(breed: Breed): Breed {
        return breedRepository.save(breed)
    }

    override fun deleteBreedById(id: UUID) {
        return breedRepository.deleteById(id)
    }

    @Transactional
    override fun updateBreed(id: UUID, updatedBreed: Breed): Breed? {
        val existingBreed = breedRepository.findById(id)
        return if (existingBreed != null) {
            existingBreed.name = updatedBreed.name
            existingBreed
        } else {
            null
        }
    }

    override fun getBreedsBySpeciesId(speciesId: UUID?): List<Breed> {
        return breedRepository.getBreedsBySpeciesId(speciesId)
    }

}