package org.acme.core.adapter.database

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.core.model.Breed
import org.acme.core.port.out.IBreedRepository
import java.util.*


@ApplicationScoped
class BreedRepository : IBreedRepository, PanacheRepository<Breed> {
    override fun findAllBreeds(): PanacheQuery<Breed> = findAll()

    override fun findById(id: UUID): Breed? = find("id", id).firstResult()

    @Transactional
    override fun save(breed: Breed): Breed {
        persist(breed)
        return breed
    }

    @Transactional
    override fun deleteById(id: UUID) {
        delete("id", id)
    }

    override fun getBreedsBySpeciesId(speciesId: UUID?): List<Breed> {
        return find("species.id", speciesId).list()
    }
}