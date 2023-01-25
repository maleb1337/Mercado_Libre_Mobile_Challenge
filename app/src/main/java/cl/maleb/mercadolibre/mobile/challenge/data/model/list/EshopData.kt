package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EshopData(
    @Json(name = "eshop_experience")
    val eshopExperience: Int? = null,
    @Json(name = "eshop_id")
    val eshopId: Int? = null,
    @Json(name = "eshop_logo_url")
    val eshopLogoUrl: String? = null,
    @Json(name = "eshop_status_id")
    val eshopStatusId: Int? = null,
    @Json(name = "nick_name")
    val nickName: String? = null,
    @Json(name = "seller")
    val seller: Int? = null,
    @Json(name = "site_id")
    val siteId: String? = null
)