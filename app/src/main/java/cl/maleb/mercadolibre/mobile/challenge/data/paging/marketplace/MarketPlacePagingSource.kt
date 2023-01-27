package cl.maleb.mercadolibre.mobile.challenge.data.paging.marketplace

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.data.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.PAGE_LIMIT
import cl.maleb.mercadolibre.mobile.challenge.utils.STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class MarketPlacePagingSource(
    private val remoteDataSource: RemoteDataSource,
    private val marketPlaceMapperFacade: MarketPlaceMapperFacade,
    private val searchQuery: String
) : PagingSource<Int, MarketPlaceListItemViewData>() {
    override fun getRefreshKey(state: PagingState<Int, MarketPlaceListItemViewData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarketPlaceListItemViewData> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val networkRequest = remoteDataSource.getListBySearch(searchQuery, position, PAGE_LIMIT)
            val marketPlaceList =
                marketPlaceMapperFacade.marketPlaceListExecuteMapper(networkRequest)
            LoadResult.Page(
                data = marketPlaceList.items,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (marketPlaceList.items.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}