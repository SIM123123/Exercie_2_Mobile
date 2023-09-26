package cstjean.mobile.Carte_fidele

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cstjean.mobile.Carte_fidele.databinding.ListItemCarteBinding
import cstjean.mobile.Carte_fidele.classes.Carte

/**
 * ViewHolder pour notre RecyclerView de travaux.
 *
 * @property binding Binding de la vue pour une cellule.
 *
 * @author Simon Lamarche et Dia Raboana
 */
class CarteHolder(private val binding: ListItemCarteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * On associe un travail à ce ViewHolder.
     *
     * @param travail Le travail associé.
     */
    fun bind(carte: Carte) {
        binding.commerceNom.text = carte.nomCommerce
        binding.numeroCarte.text = carte.numeroCarte
        binding.typeCommerce.text = carte.typeCommerce.toString()
    }
}

/**
 * Adapter pour notre RecyclerView de travaux.
 *
 * @property travaux Liste des travaux à afficher.
 *
 * @author Gabriel T. St-Hilaire
 */
class CartesListAdapter(private val cartes: List<Carte>) :
    RecyclerView.Adapter<CarteHolder>() {

    /**
     * Lors de la création des ViewHolder.
     *
     * @param parent Layout dans lequel la nouvelle vue
     *                 sera ajoutée quand elle sera liée à une position.
     * @param viewType Le type de vue de la nouvelle vue.
     *
     * @return Un ViewHolder pour notre cellule.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarteHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCarteBinding.inflate(inflater, parent, false)
        return CarteHolder(binding)
    }

    /**
     * Associe un élément à un ViewHolder.
     *
     * @param holder Le ViewHolder à utiliser.
     * @param position La position dans la liste qu'on souhaite utiliser.
     */
    override fun onBindViewHolder(holder: CarteHolder, position: Int) {
        val carte = cartes[position]
        holder.bind(carte)
    }

    /**
     * Récupère le nombre total d'item de notre liste.
     *
     * @return Le nombre d'item total de notre liste.
     */
    override fun getItemCount() = cartes.size
}
