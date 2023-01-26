package cl.maleb.mercadolibre.mobile.challenge.database

import androidx.paging.PagingSource
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.remotekey.RemoteKeyData
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    //region Marketplace
    suspend fun insertMarketPlaceList(listItemViewData: List<MarketPlaceListItemViewData>)
    fun getMarketPlaceList(): PagingSource<Int, MarketPlaceListItemViewData>
    suspend fun deleteMarketPlaceList()
    //endregion

    //region Remote Key
    suspend fun insertOrReplaceRemoteKey(remoteKey: RemoteKeyData)
    fun getRemoteKey(endpointName: String): Flow<RemoteKeyData>
    suspend fun deleteRemoteKey(endpointName: String)
    //endregion
}