package cl.maleb.mercadolibre.mobile.challenge.utils.remotedatasource

import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.data.model.detail.MainResponseDetailData
import cl.maleb.mercadolibre.mobile.challenge.data.model.list.MainResponseListData

open class RemoteFakeDataSource : RemoteDataSource {
    override suspend fun getListBySearch(
        searchQuery: String,
        offset: Int,
        limit: Int
    ): MainResponseListData =
        MainResponseListData(listOf())

    override suspend fun getDetailById(identifier: String): List<MainResponseDetailData> =
        listOf()
}