package cl.maleb.mercadolibre.mobile.challenge.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.maleb.mercadolibre.mobile.challenge.database.marketplace.MarketPlaceDao
import cl.maleb.mercadolibre.mobile.challenge.database.remotekey.RemoteKeyDao
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.converters.MarketPlaceConverter
import cl.maleb.mercadolibre.mobile.challenge.utils.remotekey.RemoteKeyData

@Database(
    entities = [
        MarketPlaceListItemViewData::class,
        RemoteKeyData::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    MarketPlaceConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun marketPlaceDao(): MarketPlaceDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}