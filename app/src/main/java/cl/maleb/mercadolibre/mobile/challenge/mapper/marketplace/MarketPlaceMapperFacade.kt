package cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace

import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData

interface MarketPlaceMapperFacade {
    fun marketPlaceListExecuteMapper(mainResponseListData: MainResponseListData): MarketPlaceListViewData
}