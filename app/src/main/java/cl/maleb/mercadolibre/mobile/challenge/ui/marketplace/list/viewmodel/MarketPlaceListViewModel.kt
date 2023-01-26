package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import cl.maleb.mercadolibre.mobile.challenge.repository.marketplace.MarketPlaceRepository
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketPlaceListViewModel @Inject constructor(private val repository: MarketPlaceRepository) :
    ViewModel() {

    /**
     * Paging section
     */

    private val _marketPlaceItemsLiveData =
        MutableLiveData<PagingData<MarketPlaceListItemViewData>>()
    val marketPlaceItemsLiveData: LiveData<PagingData<MarketPlaceListItemViewData>> =
        _marketPlaceItemsLiveData

    fun getMarketPlaceList(searchQuery: String) {
        viewModelScope.launch {
            // if you want you can try with cache, but it has a weird behaviour, that's why is without cache now.
            repository.getMarketPlaceListWithoutCache(searchQuery).collect {
                _marketPlaceItemsLiveData.value = it
            }
        }
    }
}