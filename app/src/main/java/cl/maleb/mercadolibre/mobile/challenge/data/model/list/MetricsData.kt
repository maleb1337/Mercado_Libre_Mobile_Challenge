package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetricsData(
    @Json(name = "cancellations")
    val cancellations: CancellationsData? = null,
    @Json(name = "claims")
    val claims: ClaimsData? = null,
    @Json(name = "delayed_handling_time")
    val delayedHandlingTime: DelayedHandlingTimeData? = null,
    @Json(name = "sales")
    val sales: SalesData? = null
)