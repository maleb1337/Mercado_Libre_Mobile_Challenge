package cl.maleb.mercadolibre.mobile.challenge.repository.marketplace

import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.database.LocalDataSource
import cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketPlaceRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val marketPlaceMapperFacade: MarketPlaceMapperFacade
) : MarketPlaceRepository {

    override fun getMarketPlaceList(
        searchQuery: String,
        limit: Int,
        offset: Int
    ): Flow<MarketPlaceListViewData> {
        TODO("Not yet implemented")
    }
}