package org.acme.core.port.out

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import org.acme.core.model.Species
import java.util.UUID

interface ISpeciesRepository {
    fun findAllSpecies(): PanacheQuery<Species>
    fun findById(id: UUID?): Species?
    fun save(species: Species): Species
    fun deleteById(id: UUID)
}