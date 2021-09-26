package amiibo.repository.model

import kotlinx.serialization.*

@Serializable
data class AmiiboResponse(val amiibo: List<Amiibo>)