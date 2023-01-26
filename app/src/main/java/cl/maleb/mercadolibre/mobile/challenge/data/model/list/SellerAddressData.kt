package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SellerAddressData(
    @Json(name = "address_line")
    val addressLine: String? = null,
    @Json(name = "city")
    val city: CityData? = null,
    @Json(name = "comment")
    val comment: String? = null,
    @Json(name = "country")
    val country: CountryData? = null,
    @Json(name = "state")
    val state: StateData? = null,
    @Json(name = "zip_code")
    val zipCode: String? = null
)