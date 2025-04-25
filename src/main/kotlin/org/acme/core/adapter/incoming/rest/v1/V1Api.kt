package org.acme.core.adapter.incoming.rest.v1

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
interface V1Api