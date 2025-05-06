package org.acme.core.port.`in`

import org.acme.core.model.FederationRegistry

interface IFederationRegistryService {
    fun getAllFederationRegistries(): List<FederationRegistry>
    fun getFederationRegistryById(id: String?): FederationRegistry?
    fun saveFederationRegistry(federationRegistry: FederationRegistry): FederationRegistry
    fun deleteFederationRegistryById(id: String)
    fun updateFederationRegistry(id: String, updatedFederationRegistry: FederationRegistry): FederationRegistry?
}