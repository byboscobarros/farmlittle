package org.acme.core.adapter.services.mapper

import java.time.ZonedDateTime

interface IBaseResponseDTO {
    var createdAt: ZonedDateTime?
    var updatedAt: ZonedDateTime?
}