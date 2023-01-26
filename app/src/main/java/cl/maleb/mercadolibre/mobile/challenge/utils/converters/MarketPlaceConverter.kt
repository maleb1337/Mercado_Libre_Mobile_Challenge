package cl.maleb.mercadolibre.mobile.challenge.utils.converters

import androidx.room.TypeConverter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.AttributeViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.PictureViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListViewData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MarketPlaceConverter {

    @TypeConverter
    fun restorePictureViewData(objectToRestore: String?): List<PictureViewData>? {
        return Gson().fromJson(
            objectToRestore,
            object : TypeToken<List<PictureViewData>?>() {}.type
        )
    }

    @TypeConverter
    fun savePictureViewData(objectToSave: List<PictureViewData>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreAttributeViewData(objectToRestore: String?): List<AttributeViewData>? {
        return Gson().fromJson(
            objectToRestore,
            object : TypeToken<List<AttributeViewData>?>() {}.type
        )
    }

    @TypeConverter
    fun saveAttributeViewData(objectToSave: List<AttributeViewData>?): String? {
        return Gson().toJson(objectToSave)
    }
}