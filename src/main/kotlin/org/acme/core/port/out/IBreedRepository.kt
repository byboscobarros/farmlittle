package org.acme.core.port.out

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import org.acme.core.model.Breed
import java.util.*

interface IBreedRepository {
    fun findAllBreeds(): PanacheQuery<Breed>
    fun findById(id: UUID): Breed?
    fun save(breed: Breed): Breed
    fun deleteById(id: UUID)
}