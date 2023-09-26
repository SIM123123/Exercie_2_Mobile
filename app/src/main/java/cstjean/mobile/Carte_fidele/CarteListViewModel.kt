package cstjean.mobile.Carte_fidele

import androidx.lifecycle.ViewModel
import cstjean.mobile.Carte_fidele.classes.Carte
import cstjean.mobile.Carte_fidele.classes.Type
import java.util.Date
import java.util.UUID

/**
 * ViewModel pour la liste des travaux.
 *
 * @property travaux La liste des travaux.
 *
 * @author Simon Lamarche et Dia Raboana
 */
class CarteListViewModel : ViewModel() {
    val cartes = mutableListOf<Carte>()

    init {
        // Données de tests
        for (i in 0 until 100) {
            cartes += Carte(
                "Commerce $i",
                "Carte #$i",
                Type.DIVERTISSEMENT,
                "#0000FF"
            )
        }
    }
}
