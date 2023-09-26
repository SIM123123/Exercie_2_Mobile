package cstjean.mobile.Carte_fidele.classes


/**
 * Une carte
 */
data class Carte(
    val nomCommerce: String,
    val numeroCarte: String,
    val typeCommerce: Type,
    val couleurCarte: String
)