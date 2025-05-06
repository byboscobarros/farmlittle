package org.acme.core.port.out

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import org.acme.core.model.FederationRegistry

interface IFederationRegistryRepository {
    fun findAllFederationRegistries(): PanacheQuery<FederationRegistry>
    fun findById(id: String?): FederationRegistry?
    fun save(federationRegistry: FederationRegistry): FederationRegistry
    fun deleteById(id: String)
}