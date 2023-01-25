package cl.maleb.mercadolibre.mobile.challenge.data.api

import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val GET_LIST_BY_QUERY = "sites/MLA/search"
        const val GET_DETAIL_BY_ID = "items"
    }

    @GET(GET_LIST_BY_QUERY)
    suspend fun getListBySearch(
        @Query("q") searchQuery: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): MainResponseListData

    @GET(GET_DETAIL_BY_ID)
    suspend fun getDetailById(
        @Query("ids") identifier: String
    ): MainResponseDetailData
}