package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InstallmentsData(
    @Json(name = "amount")
    val amount: Double? = null,
    @Json(name = "currency_id")
    val currencyId: String? = null,
    @Json(name = "quantity")
    val quantity: Int? = null
)