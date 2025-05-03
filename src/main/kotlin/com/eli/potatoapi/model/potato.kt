package com.eli.potatoapi.model

import java.time.OffsetDateTime
import jakarta.persistence.*

@Entity
@Table(name = "potato")
data class Potato(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val variety: String,
    val color: String?,
    val originCountry: String?,
    val weightGrams: Int?,
    val organic: Boolean = false,

    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    val updatedAt: OffsetDateTime = OffsetDateTime.now()
)
