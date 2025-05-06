package org.acme.core.port.`in`

import org.acme.core.model.Federation

interface IFederationService {
    fun getAllFederations(): List<Federation>
    fun getFederationById(id: String?): Federation?
    fun saveFederation(federation: Federation): Federation
    fun deleteFederationById(id: String)
    fun updateFederation(id: String, updatedFederation: Federation): Federation?
}