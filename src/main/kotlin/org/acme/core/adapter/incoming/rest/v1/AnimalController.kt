package org.acme.core.adapter.incoming.rest.v1

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response
import org.acme.core.adapter.incoming.rest.v1.DTO.AnimalRequestDTO
import org.acme.core.adapter.services.AnimalService
import org.acme.core.adapter.services.mapper.AnimalMapper

import java.util.*

@Path("/v1/animals")
class AnimalController(
    private val animalService: AnimalService,
    private val animalMapper: AnimalMapper
) : V1Api {
    @GET
    fun getAll(): Response =
        Response.status(Response.Status.OK).entity(animalMapper.toDtoList(animalService.getAllAnimals())).build()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: UUID): Response {
        val animal = animalService.getAnimalById(id)
        if (animal != null) {
            return Response.status(Response.Status.OK).entity(animalMapper.toDto(animal)).build()
        }
        return Response.status(Response.Status.NOT_FOUND).build()
    }

    @POST
    fun create(@Valid animalRequestDTO: AnimalRequestDTO): Response {
        val saved = animalService.saveAnimal(animalMapper.toEntity(animalRequestDTO))
        return Response.status(Response.Status.CREATED).entity(animalMapper.toDto(saved)).build()
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: UUID, @Valid updatedAnimalDTO: AnimalRequestDTO): Response {
        val animal = animalService.updateAnimal(id, animalMapper.toEntity(updatedAnimalDTO))
        return if (animal != null) {
            Response.status(Response.Status.OK).entity(animalMapper.toDto(animal)).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: UUID): Response {
        animalService.deleteAnimalById(id)
        return Response.noContent().build()
    }
}