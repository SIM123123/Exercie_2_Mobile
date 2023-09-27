package cstjean.mobile.Carte_fidele.classes

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


/**
 * Une carte
 */
@Entity
data class Carte(
    @PrimaryKey val id: UUID,
    val nomCommerce: String,
    val numeroCarte: String,
    val typeCommerce: Type,
    val couleurCarte: String
)