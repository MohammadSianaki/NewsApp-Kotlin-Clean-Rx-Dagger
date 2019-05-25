package ir.siatech.newsappkotlinclean.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.siatech.newsappkotlinclean.data.entities.SourceData

class Converters {
    @TypeConverter
    fun fromSource(source: SourceData?): String? {
        return if (source == null) null else Gson().toJson(source)
    }

    @TypeConverter
    fun toSource(value: String?): SourceData? {
        return if (value == null) null
        else Gson().fromJson<SourceData>(value, object : TypeToken<SourceData>() {}.type)
    }
}