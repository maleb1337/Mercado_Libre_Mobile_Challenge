package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddressData(
    @Json(name = "city_id")
    val cityId: String? = null,
    @Json(name = "city_name")
    val cityName: String? = null,
    @Json(name = "state_id")
    val stateId: String? = null,
    @Json(name = "state_name")
    val stateName: String? = null
)