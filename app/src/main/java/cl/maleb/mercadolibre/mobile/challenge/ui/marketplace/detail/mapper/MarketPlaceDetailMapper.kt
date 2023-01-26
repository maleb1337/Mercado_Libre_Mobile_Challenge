package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.mapper

import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.AttributeData
import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.PictureData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.AttributeViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.PictureViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.Mapper
import javax.inject.Inject

class MarketPlaceDetailMapper @Inject constructor() :
    Mapper<MarketPlaceDetailViewData, MainResponseDetailData> {
    override fun executeMapping(type: MainResponseDetailData): MarketPlaceDetailViewData {
        type.body.let { data ->
            return MarketPlaceDetailViewData(
                marketPlaceIdentifier = data?.id.orEmpty(),
                pictures = parsePictureViewData(data?.pictures),
                attributes = parseAttributeViewData(data?.attributes),
                title = data?.title.orEmpty(),
                price = data?.price ?: 0,
                condition = data?.condition.orEmpty()
            )
        }
    }

    private fun parseAttributeViewData(attributes: List<AttributeData>?): List<AttributeViewData> {
        return attributes?.map {
            AttributeViewData(
                name = it.name.orEmpty(),
                valueName = it.valueName.orEmpty()
            )
        }.orEmpty()
    }

    private fun parsePictureViewData(pictures: List<PictureData>?): List<PictureViewData> {
        return pictures?.map {
            PictureViewData(
                imageUrl = it.secureUrl.orEmpty()
            )
        }.orEmpty()
    }
}