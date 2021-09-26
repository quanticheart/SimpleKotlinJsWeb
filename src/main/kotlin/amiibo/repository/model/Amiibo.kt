package amiibo.repository.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amiibo(
    @SerialName("character")
    val character: String,
    @SerialName("name")
    val name: String
)