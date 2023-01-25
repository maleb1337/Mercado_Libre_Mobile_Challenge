package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainResponseDetailData(
    @Json(name = "body")
    val body: ResponseDetailData? = null
)
