package cl.maleb.mercadolibre.mobile.challenge.data.model.list

data class SellerAddress(
    val address_line: String,
    val city: CityData,
    val comment: String,
    val country: CountryData,
    val id: Any,
    val latitude: Any,
    val longitude: Any,
    val state: StateData,
    val zip_code: String
)