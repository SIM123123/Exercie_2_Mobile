package cstjean.mobile.Carte_fidele.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cstjean.mobile.Carte_fidele.classes.Carte
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CarteDao {
    @Query("SELECT * FROM carte")
    fun getCartes(): Flow<List<Carte>>
    @Query("SELECT * FROM carte WHERE id=(:id)")
    suspend fun getCarte(id: UUID): Carte
    @Insert
    suspend fun addCarte(carte: Carte)
}