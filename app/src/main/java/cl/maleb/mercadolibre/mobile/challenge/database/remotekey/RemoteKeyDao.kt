package cl.maleb.mercadolibre.mobile.challenge.database.remotekey

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.maleb.mercadolibre.mobile.challenge.utils.remotekey.RemoteKeyData
import kotlinx.coroutines.flow.Flow

/**
 * This is intended to be used on paging 3 with remote mediator usage,
 * to paginate correctly, with the help of currentPage and nextPage
 */

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceRemoteKey(remoteKey: RemoteKeyData)

    @Query("SELECT * FROM remoteKeyTable WHERE endpointName = :endpointName")
    fun getRemoteKey(endpointName: String): Flow<RemoteKeyData>

    @Query("DELETE FROM remoteKeyTable WHERE endpointName = :endpointName")
    suspend fun deleteRemoteKey(endpointName: String)
}