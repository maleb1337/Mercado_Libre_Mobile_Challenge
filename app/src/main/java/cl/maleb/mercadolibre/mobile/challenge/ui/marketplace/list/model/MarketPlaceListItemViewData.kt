package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marketPlaceListItemViewDataTable")
data class MarketPlaceListItemViewData(
    @PrimaryKey(autoGenerate = true) val idAutoIncrement: Int = 0,
    val marketPlaceIdentifier: String,
    val imageUrl: String,
    val brandName: String,
    val productName: String,
    val price: Int,
    val orderBackend: Int
)
