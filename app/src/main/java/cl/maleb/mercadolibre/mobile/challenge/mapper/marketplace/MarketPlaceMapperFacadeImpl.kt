package cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace

import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.mapper.MarketPlaceListMapper
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketPlaceMapperFacadeImpl @Inject constructor(
    private val marketPlaceListMapper: MarketPlaceListMapper
) : MarketPlaceMapperFacade {
    override fun marketPlaceListExecuteMapper(mainResponseListData: MainResponseListData): MarketPlaceListViewData =
        marketPlaceListMapper.executeMapping(mainResponseListData)
}