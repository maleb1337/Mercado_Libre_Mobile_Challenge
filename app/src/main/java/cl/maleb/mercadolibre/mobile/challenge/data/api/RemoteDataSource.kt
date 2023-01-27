package cl.maleb.mercadolibre.mobile.challenge.data.api

import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import retrofit2.http.Query

interface RemoteDataSource {
    suspend fun getListBySearch(
        @Query("q") searchQuery: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): MainResponseListData

    suspend fun getDetailById(@Query("ids") identifier: String): List<MainResponseDetailData>
}