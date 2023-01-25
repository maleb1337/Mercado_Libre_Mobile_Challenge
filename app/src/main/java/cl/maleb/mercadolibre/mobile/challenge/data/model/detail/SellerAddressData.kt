package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SellerAddressData(
    @Json(name = "city")
    val city: CityData? = null,
    @Json(name = "country")
    val country: CountryData? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "search_location")
    val searchLocation: SearchLocationData? = null,
    @Json(name = "state")
    val state: StateData? = null
)