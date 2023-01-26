package cl.maleb.mercadolibre.mobile.challenge.repository.marketplace

import androidx.paging.PagingData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.network.Resource
import kotlinx.coroutines.flow.Flow

interface MarketPlaceRepository {
    fun getMarketPlaceListWithCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>>
    fun getMarketPlaceListWithoutCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>>
    fun getMarketPlaceDetail(marketPlaceIdentifier: String): Flow<Resource<MarketPlaceDetailViewData>>
}