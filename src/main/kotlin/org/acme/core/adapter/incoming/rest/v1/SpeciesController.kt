package org.acme.core.adapter.incoming.rest.v1

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response
import org.acme.core.model.Species
import org.acme.core.port.`in`.ISpeciesService
import java.util.*

@Path("/v1/species")
@ApplicationScoped
class SpeciesController (
    private val speciesService: ISpeciesService
) : V1Api {
    @GET
    fun getAll(): List<Species> = speciesService.getAllSpecies()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: UUID): Species? = speciesService.getSpeciesById(id)

    @POST
    fun create(species: Species): Response {
        val saved = speciesService.saveSpecies(species)
        return Response.status(Response.Status.CREATED).entity(saved).build()
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: UUID, updatedSpecies: Species): Response {
        val species = speciesService.updateSpecies(id, updatedSpecies)
        return if (species != null) {
            Response.status(Response.Status.OK).entity(species).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: UUID): Response {
        speciesService.deleteSpeciesById(id)
        return Response.noContent().build()
    }
}