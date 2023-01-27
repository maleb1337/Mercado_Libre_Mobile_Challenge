package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.maleb.mercadolibre.mobile.challenge.repository.marketplace.MarketPlaceRepository
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketPlaceDetailViewModel @Inject constructor(private val repository: MarketPlaceRepository) :
    ViewModel() {

    private val _marketPlaceDetailLiveData =
        MutableLiveData<Resource<MarketPlaceDetailViewData>>()
    val marketPlaceDetailLiveData: LiveData<Resource<MarketPlaceDetailViewData>> =
        _marketPlaceDetailLiveData

    fun getMarketPlaceDetail(marketPlaceIdentifier: String) {
        viewModelScope.launch {
            repository.getMarketPlaceDetail(marketPlaceIdentifier).collect {
                _marketPlaceDetailLiveData.value = it
            }
        }
    }
}