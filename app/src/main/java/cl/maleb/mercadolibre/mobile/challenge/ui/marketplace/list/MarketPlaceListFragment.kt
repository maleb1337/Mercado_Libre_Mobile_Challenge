package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.mobile.challenge.R
import cl.maleb.mercadolibre.mobile.challenge.databinding.FragmentMarketplaceListBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.adapter.MarketPlaceListAdapter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.adapter.MarketPlaceListLoadStateAdapter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.events.MarketPlaceListEvent
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.viewmodel.MarketPlaceListViewModel
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.onQueryTextSubmit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketPlaceListFragment : Fragment() {

    var binding: FragmentMarketplaceListBinding? = null
    private val viewModel: MarketPlaceListViewModel by viewModels()
    private val marketPlaceListAdapter by lazy { MarketPlaceListAdapter() }
    private lateinit var searchView: SearchView

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
        setHasOptionsMenu(true)
        // set up paging adapter
        marketPlaceListAdapter.onItemClickListener = { item ->
            viewModel.navigateToDetailScreenEvent(item.marketPlaceIdentifier)
        }
        binding?.recyclerView?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = marketPlaceListAdapter.withLoadStateHeaderAndFooter(
                header = MarketPlaceListLoadStateAdapter { marketPlaceListAdapter.retry() },
                footer = MarketPlaceListLoadStateAdapter { marketPlaceListAdapter.retry() }
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_marketplace_list, menu)
        val searchItem = menu.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView

        searchView.onQueryTextSubmit { query ->
            // update search query
            if (query.isNotEmpty()) {
                viewModel.searchByQueryEvent(query)
                viewModel.lastSearchQuery = query
            }
        }
    }

    private fun initObservers() {
        viewModel.marketPlaceItemsLiveData.observe(viewLifecycleOwner) { pagingData ->
            marketPlaceListAdapter.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.marketPlaceListEvent.collect { event ->
                when (event) {
                    is MarketPlaceListEvent.NavigateToDetailScreen -> {
                        val action =
                            MarketPlaceListFragmentDirections.actionMarketPlaceListFragmentToMarketPlaceDetailFragment(
                                event.marketPlaceIdentifier
                            )
                        findNavController().navigate(action)
                    }
                    is MarketPlaceListEvent.SearchByQuery -> {
                        viewModel.getMarketPlaceList(event.searchQuery)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}