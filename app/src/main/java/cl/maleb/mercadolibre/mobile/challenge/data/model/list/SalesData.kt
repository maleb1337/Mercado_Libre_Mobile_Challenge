package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SalesData(
    @Json(name = "completed")
    val completed: Int? = null,
    @Json(name = "period")
    val period: String? = null
)