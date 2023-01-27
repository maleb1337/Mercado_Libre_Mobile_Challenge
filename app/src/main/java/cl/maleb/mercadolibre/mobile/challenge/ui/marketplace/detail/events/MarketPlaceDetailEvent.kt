package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.events

sealed class MarketPlaceDetailEvent {
    data class GetMarketDetail(val marketPlaceIdentifier: String) : MarketPlaceDetailEvent()
}