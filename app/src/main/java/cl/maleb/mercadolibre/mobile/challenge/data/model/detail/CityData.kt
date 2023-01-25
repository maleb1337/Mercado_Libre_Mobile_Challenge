package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityData(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null
)