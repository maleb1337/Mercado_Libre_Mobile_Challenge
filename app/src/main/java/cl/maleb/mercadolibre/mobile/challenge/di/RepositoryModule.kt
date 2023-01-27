package cl.maleb.mercadolibre.mobile.challenge.di

import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.database.LocalDataSource
import cl.maleb.mercadolibre.mobile.challenge.data.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.repository.marketplace.MarketPlaceRepository
import cl.maleb.mercadolibre.mobile.challenge.repository.marketplace.MarketPlaceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMarketPlaceRepositoryImpl(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        marketPlaceMapperFacade: MarketPlaceMapperFacade
    ) = MarketPlaceRepositoryImpl(
        remoteDataSource,
        localDataSource,
        marketPlaceMapperFacade
    ) as MarketPlaceRepository
}