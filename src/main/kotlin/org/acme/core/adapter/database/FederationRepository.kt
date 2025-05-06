package org.acme.core.adapter.database

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.core.model.Federation
import org.acme.core.port.out.IFederationRepository

class FederationRepository : IFederationRepository, PanacheRepository<Federation> {
    override fun findAllFederations(): PanacheQuery<Federation> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String?): Federation? {
        TODO("Not yet implemented")
    }

    override fun save(federation: Federation): Federation {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}