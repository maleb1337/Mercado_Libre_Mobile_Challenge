package cl.maleb.mercadolibre.mobile.challenge.repository.marketplace

import androidx.paging.Pager
import androidx.paging.PagingData
import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.database.LocalDataSource
import cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.paging.marketplace.MarketPlacePagingSource
import cl.maleb.mercadolibre.mobile.challenge.paging.marketplace.MarketPlaceRemoteMediator
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.getDefaultPagingConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketPlaceRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val marketPlaceMapperFacade: MarketPlaceMapperFacade
) : MarketPlaceRepository {

    override fun getMarketPlaceListWithCache(
        searchQuery: String
    ): Flow<PagingData<MarketPlaceListItemViewData>> =
        Pager(
            config = getDefaultPagingConfig(),
            remoteMediator = MarketPlaceRemoteMediator(
                remoteDataSource, localDataSource, marketPlaceMapperFacade, searchQuery
            )
        ) {
            localDataSource.getMarketPlaceList()
        }.flow

    override fun getMarketPlaceListWithoutCache(searchQuery: String): Flow<PagingData<MarketPlaceListItemViewData>> =
        Pager(
            config = getDefaultPagingConfig(),
            pagingSourceFactory = {
                (MarketPlacePagingSource(
                    remoteDataSource, marketPlaceMapperFacade, searchQuery
                ))
            }
        ).flow

}