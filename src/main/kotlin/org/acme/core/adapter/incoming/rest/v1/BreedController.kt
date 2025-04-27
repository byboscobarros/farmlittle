package org.acme.core.adapter.incoming.rest.v1

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.Response
import org.acme.core.model.Breed
import org.acme.core.port.`in`.IBreedService

@Path("/v1/breeds")
class BreedController (
    private val breedService: IBreedService
) : V1Api  {
    @GET
    fun getAll(): List<Breed> =
        breedService.getAllBreeds()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: java.util.UUID): Breed? =
        breedService.getBreedById(id)

    @POST
    fun create(breed: Breed): Response {
        val saved = breedService.saveBreed(breed)
        return Response.status(Response.Status.CREATED).entity(saved).build()
    }
}