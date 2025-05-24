package org.acme.core.adapter.database

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.core.model.Animal
import org.acme.core.port.out.IAnimalRepository
import java.util.*

@ApplicationScoped
class AnimalRepository : IAnimalRepository, PanacheRepository<Animal> {
    override fun findAll(): PanacheQuery<Animal> = super.findAll()

    override fun findById(id: UUID?): Animal? = find("id", id).firstResult()

    @Transactional
    override fun save(animal: Animal): Animal {
        persist(animal)
        return animal
    }

    @Transactional
    override void fun deleteById(id: UUID) {
        delete("id", id)
    }

    override fun listAllAnimals(): List<Animal> = listAll()
}