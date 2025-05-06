package org.acme.core.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import lombok.NoArgsConstructor
import java.time.ZonedDateTime
import java.util.*

@Entity
@NoArgsConstructor
class Species(
    id: UUID?,

    @Column(nullable = false)
    var name: String?,

    @OneToMany(mappedBy = "species", cascade = [CascadeType.ALL], orphanRemoval = true)
    var breeds: MutableList<Breed> = mutableListOf(),
    createdAt: ZonedDateTime?,
    updatedAt: ZonedDateTime?
) : BaseModel(id, createdAt, updatedAt)