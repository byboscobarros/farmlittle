package org.acme.core.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "federation_registries")
class FederationRegistry(
    id: UUID,

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    var animal: Animal,

    @ManyToOne
    @JoinColumn(name = "federation_id", nullable = false)
    var federation: Federation,

    @Column(nullable = false)
    var registryNumber: String,
    @Column(nullable = false)
    var registryDate: Date,
    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime
) : BaseModel(id, createdAt, updatedAt) {
}