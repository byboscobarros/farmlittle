package org.acme.core.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "federations")
class Federation(
    id: UUID,

    @Column(nullable = false)
    var name: String? = null,
    var logo: String? = null,
    var website: String? = null,

    @Column(nullable = false)
    var email: String? = null,

    @Column(nullable = false)
    var phone: String? = null,
    var address: String? = null,
    var city: String? = null,
    var state: String? = null,
    var country: String? = null,
    var postalCode: String? = null,
    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime
) : BaseModel(id, createdAt, updatedAt) {}