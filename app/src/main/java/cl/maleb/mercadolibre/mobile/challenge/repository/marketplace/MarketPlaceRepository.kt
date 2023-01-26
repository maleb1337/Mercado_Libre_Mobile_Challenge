package cl.maleb.mercadolibre.mobile.challenge.repository.marketplace

import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData
import kotlinx.coroutines.flow.Flow

interface MarketPlaceRepository {
    fun getMarketPlaceList(searchQuery: String, limit: Int, offset: Int): Flow<MarketPlaceListViewData>
}