package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VariationData(
    @Json(name = "attribute_combinations")
    val attributeCombinations: List<AttributeCombinationData>? = null,
    @Json(name = "available_quantity")
    val availableQuantity: Int? = null,
    @Json(name = "catalog_product_id")
    val catalogProductId: String? = null,
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "picture_ids")
    val pictureIds: List<String>? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "sold_quantity")
    val soldQuantity: Int? = null
)