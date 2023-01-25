package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.maleb.mercadolibre.mobile.challenge.databinding.FragmentMarketplaceListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketPlaceListFragment : Fragment() {

    var binding: FragmentMarketplaceListBinding? = null
    // TODO: Implement view model

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketplaceListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: setUpView(), initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}