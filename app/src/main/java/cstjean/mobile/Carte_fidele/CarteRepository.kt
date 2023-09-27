package cstjean.mobile.Carte_fidele

import android.content.Context
import androidx.room.Room
import cstjean.mobile.Carte_fidele.classes.Carte
import cstjean.mobile.Carte_fidele.database.CarteDatabase
import kotlinx.coroutines.flow.Flow
import java.util.UUID

private const val DATABASE_NAME = "carte-database"
class CarteRepository private constructor(context: Context){

    private val database: CarteDatabase = Room.databaseBuilder(
        context.applicationContext,
        CarteDatabase::class.java,
        DATABASE_NAME
    )
        //.createFromAsset(DATABASE_NAME)
        .build()

    fun getCartes(): Flow<List<Carte>> = database.carteDao().getCartes()
    suspend fun getCarte(id: UUID): Carte = database.carteDao().getCarte(id)

    suspend fun addCarte(carte: Carte){
        database.carteDao().addCarte(carte)
    }
    companion object{
        private var INSTANCE: CarteRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CarteRepository(context)
            }
        }
        fun get(): CarteRepository {
            return INSTANCE ?:
            throw IllegalStateException("CarteRepository doit être initialisé.")
        }
    }
}