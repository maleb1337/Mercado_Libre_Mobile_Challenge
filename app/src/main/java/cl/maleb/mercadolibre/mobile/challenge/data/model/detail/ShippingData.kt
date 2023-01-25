package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShippingData(
    @Json(name = "free_shipping")
    val freeShipping: Boolean,
    @Json(name = "local_pick_up")
    val localPickUp: Boolean,
    @Json(name = "logistic_type")
    val logisticType: String,
    @Json(name = "mode")
    val mode: String,
    @Json(name = "store_pick_up")
    val storePickUp: Boolean,
    @Json(name = "tags")
    val tags: List<String>
)