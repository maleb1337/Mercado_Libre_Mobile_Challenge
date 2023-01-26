package cl.maleb.mercadolibre.mobile.challenge.utils

import androidx.paging.PagingConfig

const val DEFAULT_PAGE_SIZE = 10
const val DEFAULT_MAX_SIZE = 100

fun getDefaultPagingConfig(
    pageSize: Int = DEFAULT_PAGE_SIZE,
    maxSize: Int = DEFAULT_MAX_SIZE,
    enablePlaceHolders: Boolean = false
) = PagingConfig(
    pageSize = pageSize, // default items size on recycler view
    maxSize = maxSize, // max size when recycler can erase items of memory
    enablePlaceholders = enablePlaceHolders
)