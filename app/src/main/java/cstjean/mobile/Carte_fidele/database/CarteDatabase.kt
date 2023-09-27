package cstjean.mobile.Carte_fidele.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cstjean.mobile.Carte_fidele.classes.Carte

@Database(entities = [Carte::class], version = 1, exportSchema = false)
@TypeConverters(CarteTypeConverter::class)
abstract class CarteDatabase : RoomDatabase() {
    abstract fun carteDao(): CarteDao
}