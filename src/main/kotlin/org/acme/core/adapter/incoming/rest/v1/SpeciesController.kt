package org.acme.core.adapter.incoming.rest.v1

import jakarta.enterprise.context.ApplicationScoped
import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response
import org.acme.core.adapter.incoming.rest.v1.DTO.SpeciesRequestDTO
import org.acme.core.adapter.services.BreedService
import org.acme.core.adapter.services.mapper.ISpeciesResponseDTO
import org.acme.core.adapter.services.mapper.SpeciesMapper
import org.acme.core.model.Species
import org.acme.core.port.`in`.IBreedService
import org.acme.core.port.`in`.ISpeciesService
import java.util.*

@Path("/v1/species")
@ApplicationScoped
class SpeciesController (
    private val speciesService: ISpeciesService,
    private val speciesMapper: SpeciesMapper
) : V1Api {
    @GET
    fun getAll(): List<ISpeciesResponseDTO> = speciesMapper.toDtoList(speciesService.getAllSpecies())

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: UUID): ISpeciesResponseDTO? {
        val species = speciesService.getSpeciesById(id)
        if(species != null) {
            return speciesMapper.toDto(species)
        }
        return null
    }

    @POST
    fun create(@Valid speciesRequestDTO: SpeciesRequestDTO): Response {
        val saved = speciesService.saveSpecies(speciesMapper.toEntity(speciesRequestDTO))
        return Response.status(Response.Status.CREATED).entity(speciesMapper.toDto(saved)).build()
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: UUID,@Valid updatedSpeciesDTO: SpeciesRequestDTO): Response {
        val species = speciesService.updateSpecies(id, speciesMapper.toEntity(updatedSpeciesDTO))
        return if (species != null) {
            Response.status(Response.Status.OK).entity(speciesMapper.toDto(species)).build()
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