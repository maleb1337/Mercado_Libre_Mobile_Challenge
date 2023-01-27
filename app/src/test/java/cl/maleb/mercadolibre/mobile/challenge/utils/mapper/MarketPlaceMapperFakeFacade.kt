package cl.maleb.mercadolibre.mobile.challenge.utils.mapper

import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.empty

open class MarketPlaceMapperFakeFacade : MarketPlaceMapperFacade {
    override fun marketPlaceListExecuteMapper(mainResponseListData: MainResponseListData): MarketPlaceListViewData =
        MarketPlaceListViewData(listOf())

    override fun marketPlaceDetailExecuteMapper(mainResponseDetailData: List<MainResponseDetailData>): MarketPlaceDetailViewData =
        MarketPlaceDetailViewData(
            String.empty(),
            listOf(),
            listOf(),
            String.empty(),
            0,
            String.empty()
        )
}