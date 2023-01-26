package cl.maleb.mercadolibre.mobile.challenge.di

import cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace.MarketPlaceMapperFacade
import cl.maleb.mercadolibre.mobile.challenge.mapper.marketplace.MarketPlaceMapperFacadeImpl
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.mapper.MarketPlaceListMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideMarketPlaceMapperFacadeImpl(
        marketPlaceListMapper: MarketPlaceListMapper
    ) = MarketPlaceMapperFacadeImpl(marketPlaceListMapper) as MarketPlaceMapperFacade
}