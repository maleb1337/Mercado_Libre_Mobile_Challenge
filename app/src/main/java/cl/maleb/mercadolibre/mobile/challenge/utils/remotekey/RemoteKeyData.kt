package cl.maleb.mercadolibre.mobile.challenge.utils.remotekey

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This is intended to be used on paging 3 with remote mediator usage,
 * to paginate correctly, with the help of currentPage and nextPage
 */

@Entity(tableName = "remoteKeyTable")
data class RemoteKeyData(
    @PrimaryKey val endpointName: String,
    val currentPage: Int
)
