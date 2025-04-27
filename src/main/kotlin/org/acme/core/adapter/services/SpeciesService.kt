package org.acme.core.adapter.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.core.model.Species
import org.acme.core.port.`in`.ISpeciesService
import org.acme.core.port.out.ISpeciesRepository
import java.time.ZonedDateTime
import java.util.*

@ApplicationScoped
class SpeciesService(
    private val speciesRepository: ISpeciesRepository
) : ISpeciesService {
    override fun getAllSpecies(): List<org.acme.core.model.Species> {
        return speciesRepository.findAllSpecies().list()
    }

    @Transactional
    override fun getSpeciesById(id: java.util.UUID): org.acme.core.model.Species? {
        return speciesRepository.findById(id)
    }

    override fun saveSpecies(species: org.acme.core.model.Species): org.acme.core.model.Species {
        return speciesRepository.save(species)
    }

    override fun deleteSpeciesById(id: java.util.UUID) {
        speciesRepository.deleteById(id)
    }

    @Transactional
    override fun updateSpecies(id: UUID, updatedSpecies: Species): Species? {
        val existingSpecies = speciesRepository.findById(id)
        existingSpecies?.breeds?.size
        return if (existingSpecies != null) {
            existingSpecies.name = updatedSpecies.name
            existingSpecies
        } else {
            null
        }
    }
}