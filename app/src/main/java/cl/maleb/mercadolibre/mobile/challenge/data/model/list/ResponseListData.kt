package cl.maleb.mercadolibre.mobile.challenge.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseListData(
    @Json(name = "accepts_mercadopago")
    val acceptsMercadoPago: Boolean? = null,
    @Json(name = "address")
    val address: AddressData? = null,
    @Json(name = "attributes")
    val attributes: List<AttributeData>? = null,
    @Json(name = "available_quantity")
    val availableQuantity: Double? = null,
    @Json(name = "buying_mode")
    val buyingMode: String? = null,
    @Json(name = "category_id")
    val categoryId: String? = null,
    @Json(name = "condition")
    val condition: String? = null,
    @Json(name = "currency_id")
    val currencyId: String? = null,
    @Json(name = "differential_pricing")
    val differentialPricing: DifferentialPricingData? = null,
    @Json(name = "domain_id")
    val domainId: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "installments")
    val installments: InstallmentsData? = null,
    @Json(name = "listing_type_id")
    val listingTypeId: String? = null,
    @Json(name = "order_backend")
    val orderBackend: Int? = null,
    @Json(name = "original_price")
    val originalPrice: Double? = null,
    @Json(name = "permalink")
    val permalink: String? = null,
    @Json(name = "price")
    val price: Double? = null,
    @Json(name = "seller")
    val seller: SellerData? = null,
    @Json(name = "seller_address")
    val sellerAddress: SellerAddressData? = null,
    @Json(name = "shipping")
    val shipping: ShippingData? = null,
    @Json(name = "site_id")
    val siteId: String? = null,
    @Json(name = "sold_quantity")
    val soldQuantity: Double? = null,
    @Json(name = "stop_time")
    val stopTime: String? = null,
    @Json(name = "tags")
    val tags: List<String>? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
    @Json(name = "thumbnail_id")
    val thumbnailId: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "use_thumbnail_id")
    val useThumbnailId: Boolean? = null,
    @Json(name = "variation_filters")
    val variationFilters: List<String>? = null
)