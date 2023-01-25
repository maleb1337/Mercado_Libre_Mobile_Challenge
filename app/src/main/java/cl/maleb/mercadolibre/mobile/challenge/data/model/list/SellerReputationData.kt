package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SellerReputationData(
    @Json(name = "level_id")
    val levelId: String? = null,
    @Json(name = "metrics")
    val metrics: MetricsData? = null,
    @Json(name = "power_seller_status")
    val powerSellerStatus: String? = null,
    @Json(name = "transactions")
    val transactions: TransactionsData? = null
)