package org.acme.core.adapter.services

import org.acme.core.port.`in`.ISpeciesService
import org.acme.core.port.out.ISpeciesRepository

class SpeciesService(
    private val speciesRepository: ISpeciesRepository
) : ISpeciesService {
    override fun getAllSpecies(): List<org.acme.core.model.Species> {
        return speciesRepository.findAll().list()
    }

    override fun getSpeciesById(id: java.util.UUID): org.acme.core.model.Species? {
        return speciesRepository.findById(id)
    }

    override fun saveSpecies(species: org.acme.core.model.Species): org.acme.core.model.Species {
        return speciesRepository.save(species)
    }

    override fun deleteSpeciesById(id: java.util.UUID) {
        speciesRepository.deleteById(id)
    }
}