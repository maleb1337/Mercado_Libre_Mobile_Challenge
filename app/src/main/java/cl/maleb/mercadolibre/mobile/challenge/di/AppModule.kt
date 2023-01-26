package cl.maleb.mercadolibre.mobile.challenge.di

import android.app.Application
import androidx.room.Room
import cl.maleb.mercadolibre.mobile.challenge.database.AppDatabase
import cl.maleb.mercadolibre.mobile.challenge.database.LocalDataSource
import cl.maleb.mercadolibre.mobile.challenge.database.LocalDataSourceImpl
import cl.maleb.mercadolibre.mobile.challenge.database.marketplace.MarketPlaceDao
import cl.maleb.mercadolibre.mobile.challenge.database.remotekey.RemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "ML_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMarketPlaceDao(appDatabase: AppDatabase) = appDatabase.marketPlaceDao()

    @Provides
    @Singleton
    fun provideRemoteKeyDao(appDatabase: AppDatabase) = appDatabase.remoteKeyDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        marketPlaceDao: MarketPlaceDao,
        remoteKeyDao: RemoteKeyDao
    ) = LocalDataSourceImpl(marketPlaceDao, remoteKeyDao) as LocalDataSource
}