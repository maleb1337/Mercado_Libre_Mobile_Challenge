package cl.maleb.mercadolibre.mobile.challenge.database.marketplace

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData

@Dao
interface MarketPlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarketPlaceList(listItemViewData: List<MarketPlaceListItemViewData>)

    @Query("SELECT * FROM marketPlaceListItemViewDataTable ORDER BY orderBackend ASC")
    fun getMarketPlaceList(): PagingSource<Int, MarketPlaceListItemViewData>

    @Query("DELETE FROM marketPlaceListItemViewDataTable")
    suspend fun deleteMarketPlaceList()
}