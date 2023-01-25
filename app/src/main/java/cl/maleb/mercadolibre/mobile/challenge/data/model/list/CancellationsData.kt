package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CancellationsData(
    @Json(name = "period")
    val period: String? = null,
    @Json(name = "rate")
    val rate: Double? = null,
    @Json(name = "value")
    val value: Int? = null
)