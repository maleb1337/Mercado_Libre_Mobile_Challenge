package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DelayedHandlingTimeData(
    @Json(name = "period")
    val period: String? = null,
    @Json(name = "rate")
    val rate: Double? = null,
    @Json(name = "time")
    val value: Int? = null
)