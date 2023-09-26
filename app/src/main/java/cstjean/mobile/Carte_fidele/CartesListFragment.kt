package cstjean.mobile.Carte_fidele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cstjean.mobile.Carte_fidele.databinding.FragmentCartesListBinding

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

        val cartes = cartesListViewModel.cartes
        val adapter = CartesListAdapter(cartes)
        binding.cartesRecyclerView.adapter = adapter

        return binding.root
    }

    /**
     * Lorsque la vue est détruite.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}