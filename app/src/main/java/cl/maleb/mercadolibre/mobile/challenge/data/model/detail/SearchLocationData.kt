package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchLocationData(
    @Json(name = "city")
    val city: CityData? = null,
    @Json(name = "state")
    val state: StateData? = null
)