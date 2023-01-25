package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RatingsData(
    @Json(name = "negative")
    val negative: Double? = null,
    @Json(name = "neutral")
    val neutral: Double? = null,
    @Json(name = "positive")
    val positive: Double? = null
)