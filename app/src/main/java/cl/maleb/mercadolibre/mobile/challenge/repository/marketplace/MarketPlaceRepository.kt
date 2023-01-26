package cl.maleb.mercadolibre.mobile.challenge.repository.marketplace

import androidx.paging.PagingData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import kotlinx.coroutines.flow.Flow

interface MarketPlaceRepository {
    fun getMarketPlaceList(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>>
}