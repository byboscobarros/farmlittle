package org.acme.core.model

import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseModel (

    @Id
    @Column(columnDefinition = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @Column(nullable = false)
    var createdAt: ZonedDateTime? = null,

    @Column(nullable = false)
    var updatedAt: ZonedDateTime? = null
) {
    @PrePersist
    fun onPrePersist() {
        val now = ZonedDateTime.now()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    fun onPreUpdate() {
        updatedAt = ZonedDateTime.now()
    }
}