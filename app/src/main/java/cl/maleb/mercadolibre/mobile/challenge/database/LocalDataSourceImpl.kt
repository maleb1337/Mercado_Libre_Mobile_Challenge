package cl.maleb.mercadolibre.mobile.challenge.database

import androidx.paging.PagingSource
import cl.maleb.mercadolibre.mobile.challenge.database.marketplace.MarketPlaceDao
import cl.maleb.mercadolibre.mobile.challenge.database.remotekey.RemoteKeyDao
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.remotekey.RemoteKeyData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(
    private val marketPlaceDao: MarketPlaceDao,
    private val remoteKeyDao: RemoteKeyDao
) : LocalDataSource {
    override suspend fun insertMarketPlaceList(listItemViewData: List<MarketPlaceListItemViewData>) =
        marketPlaceDao.insertMarketPlaceList(listItemViewData)

    override fun getMarketPlaceList(): PagingSource<Int, MarketPlaceListItemViewData> =
        marketPlaceDao.getMarketPlaceList()

    override suspend fun deleteMarketPlaceList() = marketPlaceDao.deleteMarketPlaceList()
    override suspend fun deleteAndInsertMarketPlaceDetail(marketPlaceDetailViewData: MarketPlaceDetailViewData) =
        marketPlaceDao.deleteAndInsertMarketPlaceDetail(marketPlaceDetailViewData)

    override fun getMarketPlaceDetail(marketPlaceIdentifier: String) =
        marketPlaceDao.getMarketPlaceDetail(marketPlaceIdentifier)

    override suspend fun insertOrReplaceRemoteKey(remoteKey: RemoteKeyData) =
        remoteKeyDao.insertOrReplaceRemoteKey(remoteKey)

    override fun getRemoteKey(endpointName: String): Flow<RemoteKeyData> =
        remoteKeyDao.getRemoteKey(endpointName)

    override suspend fun deleteRemoteKey(endpointName: String) =
        remoteKeyDao.deleteRemoteKey(endpointName)

}