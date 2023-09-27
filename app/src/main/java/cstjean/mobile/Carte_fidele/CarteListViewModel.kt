package cstjean.mobile.Carte_fidele

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cstjean.mobile.Carte_fidele.classes.Carte
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import cstjean.mobile.Carte_fidele.classes.Type
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Date
import java.util.UUID

/**
 * ViewModel pour la liste des cartes.
 *
 * @property travaux La liste des cartes.
 *
 * @author Simon Lamarche et Dia Raboana
 */
class CarteListViewModel : ViewModel() {
    private val carteRepository = CarteRepository.get()
    private val _cartes: MutableStateFlow<List<Carte>> = MutableStateFlow(emptyList())
    val cartes: StateFlow<List<Carte>> = _cartes
    init {
        viewModelScope.launch{
           // loadCartes()

            carteRepository.getCartes().collect {
                _cartes.value = it
            }
        }
    }

    suspend fun loadCartes(){
        delay(5000)
        for (i in 0 until 100) {
            val carte = Carte(
                UUID.randomUUID(),
                "Commerce $i",
                "Carte #$i",
                Type.DIVERTISSEMENT,
                "#0000FF"
            )
            addCarte(carte)
        }
    }
    suspend fun addCarte(carte: Carte){
        carteRepository.addCarte(carte)
    }
}
