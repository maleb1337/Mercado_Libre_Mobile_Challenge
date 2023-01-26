package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marketPlaceDetailViewDataTable")
data class MarketPlaceDetailViewData(
    @PrimaryKey val marketPlaceIdentifier: String,
    val pictures: List<PictureViewData>,
    val attributes: List<AttributeViewData>,
    val title: String,
    val price: Int,
    val condition: String
)