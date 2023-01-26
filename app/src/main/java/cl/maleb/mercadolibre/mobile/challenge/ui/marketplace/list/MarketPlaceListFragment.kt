package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.mobile.challenge.databinding.FragmentMarketplaceListBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.adapter.MarketPlaceListAdapter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.adapter.MarketPlaceListLoadStateAdapter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.viewmodel.MarketPlaceListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketPlaceListFragment : Fragment() {

    var binding: FragmentMarketplaceListBinding? = null
    private val viewModel: MarketPlaceListViewModel by viewModels()
    private val marketPlaceListAdapter by lazy { MarketPlaceListAdapter() }

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
        initObservers()
        setUpView()
    }

    private fun setUpView() {
        // set up paging adapter
        marketPlaceListAdapter.onItemClickListener = { item ->
            // TODO: redirect to detail
            item.marketPlaceIdentifier
        }
        binding?.recyclerView?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = marketPlaceListAdapter.withLoadStateHeaderAndFooter(
                header = MarketPlaceListLoadStateAdapter { marketPlaceListAdapter.retry() },
                footer = MarketPlaceListLoadStateAdapter { marketPlaceListAdapter.retry() }
            )
        }
        // TODO: remove this, just for testing
        viewModel.getMarketPlaceList("Sir Fausto")
    }

    private fun initObservers() {
        viewModel.marketPlaceItemsLiveData.observe(viewLifecycleOwner) { pagingData ->
            marketPlaceListAdapter.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}