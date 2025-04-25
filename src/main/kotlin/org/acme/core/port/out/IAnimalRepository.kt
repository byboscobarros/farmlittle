package org.acme.core.port.out

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import org.acme.core.model.Animal
import java.util.*

interface IAnimalRepository {
    fun findAll(): PanacheQuery<Animal>
    fun findById(id: UUID): Animal?
    fun save(animal: Animal): Animal
    fun deleteById(id: UUID)
    fun listAllAnimals(): List<Animal>
}