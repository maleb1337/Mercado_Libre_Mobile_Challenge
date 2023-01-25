package cl.maleb.mercadolibre.mobile.challenge.data.api

import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    RemoteDataSource {
    override suspend fun getListBySearch(
        searchQuery: String,
        offset: Int,
        limit: Int
    ): MainResponseListData = apiService.getListBySearch(searchQuery, offset, limit)

    override suspend fun getDetailById(identifier: String): MainResponseDetailData =
        apiService.getDetailById(identifier)

}