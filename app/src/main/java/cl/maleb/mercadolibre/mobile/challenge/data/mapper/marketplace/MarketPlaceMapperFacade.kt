package cl.maleb.mercadolibre.mobile.challenge.data.mapper.marketplace

import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData

interface MarketPlaceMapperFacade {
    fun marketPlaceListExecuteMapper(mainResponseListData: MainResponseListData): MarketPlaceListViewData
    fun marketPlaceDetailExecuteMapper(mainResponseDetailData: List<MainResponseDetailData>): MarketPlaceDetailViewData
}