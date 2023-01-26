package cl.maleb.mercadolibre.mobile.challenge.repository.marketplace

import androidx.paging.PagingData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import kotlinx.coroutines.flow.Flow

interface MarketPlaceRepository {
    fun getMarketPlaceListWithCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>>
    fun getMarketPlaceListWithoutCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>>
}