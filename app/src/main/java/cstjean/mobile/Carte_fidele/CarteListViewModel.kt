package cstjean.mobile.Carte_fidele

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import cstjean.mobile.Carte_fidele.classes.Carte
import cstjean.mobile.Carte_fidele.classes.Type
import io.github.serpro69.kfaker.Faker

/**
 * ViewModel pour la liste des travaux.
 *
 * @property travaux La liste des travaux.
 *
 * @author Simon Lamarche et Dia Raboana
 */
class CarteListViewModel : ViewModel() {
    val cartes = mutableListOf<Carte>()
    val faker = Faker()

    init {
        // Données de tests
        for (i in 0 until 5) {
            cartes += Carte(
                faker.commerce.brand(),
                faker.business.creditCardNumbers(),
                faker.random.nextEnum<Type>(),
                "#6C83B1"
            )
        }
    }
}
