package org.acme.core.adapter.database

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.core.model.FederationRegistry
import org.acme.core.port.out.IFederationRegistryRepository

class FederationResgistryRepository : IFederationRegistryRepository, PanacheRepository<FederationRepository> {
    override fun findAllFederationRegistries(): PanacheQuery<FederationRegistry> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String?): FederationRegistry? {
        TODO("Not yet implemented")
    }

    override fun save(federationRegistry: FederationRegistry): FederationRegistry {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}