package org.acme.core.adapter.incoming.rest.v1

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response
import org.acme.core.adapter.incoming.rest.v1.DTO.BreedRequestDTO
import org.acme.core.adapter.services.mapper.BreedMapper
import org.acme.core.adapter.services.mapper.IBreedRequestDTO
import org.acme.core.adapter.services.mapper.IBreedResponseDTO
import org.acme.core.model.Breed
import org.acme.core.port.`in`.IBreedService
import java.util.*

@Path("/v1/breeds")
class BreedController (
    private val breedService: IBreedService,
    private val breedMapper: BreedMapper
) : V1Api  {
    @GET
    fun getAll(): List<IBreedResponseDTO> =
        breedMapper.toDtoList(breedService.getAllBreeds())

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: java.util.UUID): IBreedResponseDTO? {
        val breed = breedService.getBreedById(id)
        if(breed != null) {
            return breedMapper.toDto(breed)
        }
        return null
    }

    @POST
    fun create(@Valid breedRequestDTO: BreedRequestDTO): Response {
        val saved = breedService.saveBreed(breedMapper.toEntity(breedRequestDTO))
        return Response.status(Response.Status.CREATED).entity(breedMapper.toDto(saved)).build()
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: UUID,@Valid updatedBreedDTO: BreedRequestDTO): Response {
        val breed = breedService.updateBreed(id, breedMapper.toEntity(updatedBreedDTO))
        return if (breed != null) {
            Response.status(Response.Status.OK).entity(breedMapper.toDto(breed)).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }


    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: UUID): Response {
        breedService.deleteBreedById(id)
        return Response.noContent().build()
    }
}