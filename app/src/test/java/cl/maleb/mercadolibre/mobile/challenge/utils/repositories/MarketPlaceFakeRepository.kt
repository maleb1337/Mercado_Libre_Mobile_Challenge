package cl.maleb.mercadolibre.mobile.challenge.utils.repositories

import androidx.paging.PagingData
import cl.maleb.mercadolibre.mobile.challenge.repository.marketplace.MarketPlaceRepository
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.network.Resource
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class MarketPlaceFakeRepository : MarketPlaceRepository {

    private var willReturnError = false

    fun setWillReturnError(value: Boolean) {
        willReturnError = value
    }

    override fun getMarketPlaceListWithCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>> {
        // TODO: paginated
        return flow {
            val item: MarketPlaceListItemViewData = mockk(relaxed = true)
        }
    }

    override fun getMarketPlaceListWithoutCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>> {
        // TODO: paginated
        return flow {
            val item: List<MarketPlaceListItemViewData> = mockk(relaxed = true)
        }
    }

    override fun getMarketPlaceDetail(marketPlaceIdentifier: String): Flow<Resource<MarketPlaceDetailViewData>> {
        return flow {
            val marketPlaceDetailViewData: MarketPlaceDetailViewData = mockk(relaxed = true)
            emit(Resource.Loading())
            if (willReturnError) {
                emit(
                    Resource.Error(Throwable())
                )
            } else {
                emit(Resource.Success(marketPlaceDetailViewData))
            }
        }
    }
}