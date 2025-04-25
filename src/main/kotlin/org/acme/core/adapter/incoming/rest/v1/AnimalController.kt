package org.acme.core.adapter.incoming.rest.v1

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.Response
import org.acme.core.adapter.services.AnimalService
import org.acme.core.model.Animal
import java.util.*

@Path("/v1/animals")
class AnimalController(
    private val animalService: AnimalService
) : V1Api {
    @GET
    fun getAll(): List<Animal> =
        animalService.getAllAnimals()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: UUID): Animal? =
        animalService.getAnimalById(id)

    @POST
    fun create(animal: Animal): Response {
        val saved = animalService.saveAnimal(animal)
        return Response.status(Response.Status.CREATED).entity(saved).build()
    }
}