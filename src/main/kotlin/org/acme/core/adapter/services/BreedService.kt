package org.acme.core.adapter.services

import jakarta.enterprise.context.ApplicationScoped
import org.acme.core.model.Breed
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.out.IBreedRepository
import java.util.*

@ApplicationScoped
class BreedService(private val breedRepository: IBreedRepository) : IBreedService {
    override fun getAllBreeds(): List<Breed> {
        return breedRepository.findAll().list()
    }

    override fun getBreedById(id: UUID): Breed? {
        return breedRepository.findById(id)
    }

    override fun saveBreed(breed: Breed): Breed {
        return breedRepository.save(breed)
    }

    override fun deleteBreedById(id: UUID) {
        breedRepository.deleteById(id)
    }

}