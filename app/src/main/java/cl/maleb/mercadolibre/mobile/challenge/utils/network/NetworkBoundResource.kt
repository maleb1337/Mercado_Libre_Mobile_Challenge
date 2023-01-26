package cl.maleb.mercadolibre.mobile.challenge.utils.network

import kotlinx.coroutines.flow.*

/**
 * This inline fun allows us
 * to have cold and hot flows usage,
 * in a api fetch to save to database situation.
 */

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline databaseQuery: () -> Flow<ResultType>,
    crossinline networkCall: suspend () -> RequestType,
    crossinline saveCallResult: suspend (RequestType) -> Unit,
    crossinline shouldNetworkCall: (ResultType) -> Boolean = { true }
) = flow {

    val data = databaseQuery().first()

    val flow = if (shouldNetworkCall(data)) {
        emit(Resource.Loading(data))

        try {
            saveCallResult(networkCall())
            databaseQuery().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            databaseQuery().map {
                Resource.Error(throwable = throwable, data = it)
            }
        }

    } else {
        databaseQuery().map { Resource.Success(it) }
    }

    emitAll(flow)

}