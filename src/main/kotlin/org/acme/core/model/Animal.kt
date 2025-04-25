package org.acme.core.model

import jakarta.persistence.*
import lombok.NoArgsConstructor
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "animals")
@NoArgsConstructor
open class Animal(
    id: UUID,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var dob: Date,
    var aproximateAge: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    var species: Species,

    @ManyToOne
    @JoinColumn(name = "breed_id", nullable = false)
    var breed: Breed,

    @Enumerated(EnumType.STRING)
    var gender: AnimalGender,

    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime
) : BaseModel(id, createdAt, updatedAt)