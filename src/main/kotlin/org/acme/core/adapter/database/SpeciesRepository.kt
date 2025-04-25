package org.acme.core.adapter.database

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.core.model.Species
import org.acme.core.port.out.ISpeciesRepository
import java.util.UUID

@ApplicationScoped
class SpeciesRepository : ISpeciesRepository, PanacheRepository<Species> {
    override fun findAllSpecies(): PanacheQuery<Species> = findAll()

    override fun findById(id: UUID): Species? = find("id", id).firstResult()

    @Transactional
    override fun save(species: Species): Species {
        if (species.id != null && findById(species.id!!) != null) {
            getSession().merge(species)
        } else {
            persist(species)
        }
        return species
    }

    @Transactional
    override fun deleteById(id: UUID) {
        delete("id", id)
    }

}