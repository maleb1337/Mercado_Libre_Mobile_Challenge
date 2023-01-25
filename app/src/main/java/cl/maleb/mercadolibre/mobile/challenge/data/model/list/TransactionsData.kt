package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionsData(
    @Json(name = "canceled")
    val canceled: Int? = null,
    @Json(name = "completed")
    val completed: Int? = null,
    @Json(name = "period")
    val period: String? = null,
    @Json(name = "ratings")
    val ratings: RatingsData? = null,
    @Json(name = "total")
    val total: Int? = null
)