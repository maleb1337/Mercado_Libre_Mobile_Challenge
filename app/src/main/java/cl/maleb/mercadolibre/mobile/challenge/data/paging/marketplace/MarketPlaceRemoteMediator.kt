package cl.maleb.mercadolibre.mobile.challenge.data.paging.marketplace

import android.provider.MediaStore.Audio.Media
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import cl.maleb.mercadolibre.mobile.challenge.data.api.ApiService
import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.database.LocalDataSource
import cl.maleb.mercadolibre.mobile.challenge.data.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.PAGE_LIMIT
import cl.maleb.mercadolibre.mobile.challenge.utils.STARTING_PAGE_INDEX
import cl.maleb.mercadolibre.mobile.challenge.utils.remotekey.RemoteKeyData
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import java.io.IOException

class MarketPlaceRemoteMediator(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val marketPlaceMapperFacade: MarketPlaceMapperFacade,
    private val searchQuery: String
) : RemoteMediator<Int, MarketPlaceListItemViewData>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MarketPlaceListItemViewData>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> STARTING_PAGE_INDEX
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND ->
                    localDataSource.getRemoteKey(ApiService.GET_LIST_BY_QUERY)
                        .first().currentPage + 1
            }

            val networkRequest = remoteDataSource.getListBySearch(searchQuery, loadKey, PAGE_LIMIT)
            val marketPlaceList =
                marketPlaceMapperFacade.marketPlaceListExecuteMapper(networkRequest)

            if (loadType == LoadType.REFRESH) {
                localDataSource.deleteMarketPlaceList()
                localDataSource.deleteRemoteKey(ApiService.GET_LIST_BY_QUERY)
            }

            localDataSource.insertMarketPlaceList(marketPlaceList.items)
            localDataSource.insertOrReplaceRemoteKey(
                RemoteKeyData(
                    ApiService.GET_LIST_BY_QUERY,
                    loadKey
                )
            )
            MediatorResult.Success(
                endOfPaginationReached = marketPlaceList.items.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}