package cl.maleb.mercadolibre.mobile.challenge.database.marketplace

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import kotlinx.coroutines.flow.Flow

@Dao
interface MarketPlaceDao {
    // region list section
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarketPlaceList(listItemViewData: List<MarketPlaceListItemViewData>)

    @Query("SELECT * FROM marketPlaceListItemViewDataTable ORDER BY orderBackend ASC")
    fun getMarketPlaceList(): PagingSource<Int, MarketPlaceListItemViewData>

    @Query("DELETE FROM marketPlaceListItemViewDataTable")
    suspend fun deleteMarketPlaceList()
    //endregion

    // region detail section
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarketPlaceDetail(marketPlaceDetailViewData: MarketPlaceDetailViewData)

    @Query("SELECT * FROM marketPlaceDetailViewDataTable WHERE marketPlaceIdentifier = :marketPlaceIdentifier")
    fun getMarketPlaceDetail(marketPlaceIdentifier: String): Flow<MarketPlaceDetailViewData>

    @Query("DELETE FROM marketPlaceDetailViewDataTable WHERE marketPlaceIdentifier = :marketPlaceIdentifier")
    fun deleteMarketPlaceDetail(marketPlaceIdentifier: String)

    @Transaction
    suspend fun deleteAndInsertMarketPlaceDetail(marketPlaceDetailViewData: MarketPlaceDetailViewData) {
        deleteMarketPlaceDetail(marketPlaceIdentifier = marketPlaceDetailViewData.marketPlaceIdentifier)
        insertMarketPlaceDetail(marketPlaceDetailViewData)
    }

    //endregion
}