package cstjean.mobile.Carte_fidele.database

import androidx.room.TypeConverter
import cstjean.mobile.Carte_fidele.classes.Type
class CarteTypeConverter {
    @TypeConverter
    fun fromText(value: String): Type {
        return value.let { Type.valueOf(it) }
    }
    @TypeConverter
    fun toType(value: Type): String {
        return value.name
    }
}