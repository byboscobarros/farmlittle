package org.acme.core.port.out

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import org.acme.core.model.Federation

interface IFederationRepository {
    fun findAllFederations(): PanacheQuery<Federation>
    fun findById(id: String?): Federation?
    fun save(federation: Federation): Federation
    fun deleteById(id: String)
}