package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.events

sealed class MarketPlaceListEvent {
    data class SearchByQuery(val searchQuery: String) : MarketPlaceListEvent()
    data class NavigateToDetailScreen(val marketPlaceIdentifier: String) : MarketPlaceListEvent()
}
