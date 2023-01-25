package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SellerData(
    @Json(name = "car_dealer")
    val carDealer: Boolean? = null,
    @Json(name = "car_dealer_logo")
    val carDealerLogo: String? = null,
    @Json(name = "eshop")
    val eshop: EshopData? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "nickname")
    val nickname: String? = null,
    @Json(name = "permalink")
    val permalink: String? = null,
    @Json(name = "real_estate_agency")
    val realEstateAgency: Boolean? = null,
    @Json(name = "registration_date")
    val registrationDate: String? = null,
    @Json(name = "seller_reputation")
    val sellerReputation: SellerReputationData? = null,
    @Json(name = "tags")
    val tags: List<String>? = null
)