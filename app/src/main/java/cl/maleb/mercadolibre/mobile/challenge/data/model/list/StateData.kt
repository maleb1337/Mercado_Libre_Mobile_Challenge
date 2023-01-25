package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StateData(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null
)