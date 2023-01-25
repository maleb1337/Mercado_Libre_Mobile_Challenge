package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShippingData(
    @Json(name = "free_shipping")
    val free_shipping: Boolean? = null,
    @Json(name = "logistic_type")
    val logistic_type: String? = null,
    @Json(name = "mode")
    val mode: String? = null,
    @Json(name = "store_pick_up")
    val store_pick_up: Boolean? = null,
    @Json(name = "tags")
    val tags: List<String>? = null
)