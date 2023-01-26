package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.mapper

import cl.maleb.mercadolibre.mobile.challenge.data.model.list.AttributeData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.ResponseListData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.ATTRIBUTE_BRAND
import cl.maleb.mercadolibre.mobile.challenge.utils.Mapper
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.empty
import javax.inject.Inject
import kotlin.math.roundToInt

class MarketPlaceListMapper @Inject constructor() :
    Mapper<MarketPlaceListViewData, MainResponseListData> {
    override fun executeMapping(type: MainResponseListData): MarketPlaceListViewData {
        return MarketPlaceListViewData(
            items = parseListDataToViewData(type.results)
        )
    }

    private fun parseListDataToViewData(results: List<ResponseListData>?): List<MarketPlaceListItemViewData> {
        return results?.map {
            MarketPlaceListItemViewData(
                marketPlaceIdentifier = it.id.orEmpty(),
                imageUrl = it.thumbnail.orEmpty(),
                brandName = parseBrandName(it.attributes),
                productName = it.title.orEmpty(),
                price = it.price?.roundToInt() ?: 0,
                orderBackend = it.orderBackend ?: 0
            )
        }.orEmpty()
    }

    private fun parseBrandName(attributes: List<AttributeData>?): String {
        return if (attributes.isNullOrEmpty()) {
            String.empty()
        } else {
            attributes.find { attribute -> attribute.id == ATTRIBUTE_BRAND }?.valueName.orEmpty()
        }
    }

}