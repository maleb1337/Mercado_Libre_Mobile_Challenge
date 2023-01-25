package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ValueStructData(
    @Json(name = "number")
    val number: Double? = null,
    @Json(name = "unit")
    val unit: String? = null
)