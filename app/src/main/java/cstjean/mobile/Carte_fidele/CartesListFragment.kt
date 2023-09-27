package cstjean.mobile.Carte_fidele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import cstjean.mobile.Carte_fidele.classes.Carte
import cstjean.mobile.Carte_fidele.classes.Type
import cstjean.mobile.Carte_fidele.databinding.FragmentCartesListBinding
import kotlinx.coroutines.flow.collect
import io.github.serpro69.kfaker.Faker
import kotlinx.coroutines.launch
import java.util.UUID

class CartesListFragment : Fragment() {
    private var _binding: FragmentCartesListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Binding est null. La vue est visible ??"
        }

    private val cartesListViewModel: CarteListViewModel by viewModels()

    /**
     * Instanciation de l'interface.
     *
     * @param inflater Pour instancier l'interface.
     * @param container Le parent qui contiendra notre interface.
     * @param savedInstanceState Les données conservées au changement d'état.
     *
     * @return La vue instanciée.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartesListBinding.inflate(inflater, container, false)

        binding.cartesRecyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    cartesListViewModel.cartes.collect() { cartes ->
                        binding.cartesRecyclerView.adapter = CartesListAdapter(cartes)
                    }
                }
            }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.fragment_cartes_list, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                val faker = Faker()
                return when (menuItem.itemId) {
                    R.id.nouveau_travail -> {
                        viewLifecycleOwner.lifecycleScope.launch {
                            val nouvelleCarte = Carte(
                                UUID.randomUUID(),
                                faker.commerce.brand(),
                                faker.business.creditCardNumbers(),
                                faker.random.nextEnum<Type>(),
                                "#FF8886"
                            )
                        }

                        /**
                         * TODO: Ajouter la carte à la liste de cartes
                         *
                         * */

                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
    /**
     * Lorsque la vue est détruite.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}