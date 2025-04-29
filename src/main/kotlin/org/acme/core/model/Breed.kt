package org.acme.core.model

import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "breeds")
class Breed(
    id: UUID?,

    @Column(nullable = false)
    var name: String,

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    var species: Species?,
    createdAt: ZonedDateTime?,
    updatedAt: ZonedDateTime?
) : BaseModel(id, createdAt, updatedAt)