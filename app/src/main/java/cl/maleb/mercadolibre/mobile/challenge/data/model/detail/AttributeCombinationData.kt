package cl.maleb.mercadolibre.mobile.challenge.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributeCombinationData(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "value_id")
    val valueId: String? = null,
    @Json(name = "value_name")
    val valueName: String? = null,
    @Json(name = "value_struct")
    val valueStruct: ValueStructData? = null,
    @Json(name = "value_type")
    val valueType: String? = null,
    @Json(name = "values")
    val values: List<ValueData>? = null
)