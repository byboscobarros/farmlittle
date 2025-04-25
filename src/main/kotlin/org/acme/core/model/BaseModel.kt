package org.acme.core.model

import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseModel (

    @Id
    @Column(columnDefinition = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,

    @Column(nullable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now(),

    @Column(nullable = false)
    var updatedAt: ZonedDateTime = ZonedDateTime.now()
)