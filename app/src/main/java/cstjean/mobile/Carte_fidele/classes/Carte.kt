package cstjean.mobile.Carte_fidele.classes

import java.util.Date

/**
 * Une carte
 */
data class Carte(
    val nomCommerce: String,
    val numeroCarte: String,
    val typeCommerce: Enum<Type>,
    val couleurCarte: Int
)