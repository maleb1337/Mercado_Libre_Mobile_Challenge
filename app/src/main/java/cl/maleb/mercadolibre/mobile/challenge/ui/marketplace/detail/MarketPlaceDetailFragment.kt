package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.mobile.challenge.R
import cl.maleb.mercadolibre.mobile.challenge.databinding.FragmentMarketplaceDetailBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.adapter.AttributeListAdapter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.adapter.ImageListAdapter
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.events.MarketPlaceDetailEvent
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.MarketPlaceDetailViewData
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.viewmodel.MarketPlaceDetailViewModel
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.gone
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.visible
import cl.maleb.mercadolibre.mobile.challenge.utils.network.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketPlaceDetailFragment : Fragment() {

    var binding: FragmentMarketplaceDetailBinding? = null
    private val viewModel: MarketPlaceDetailViewModel by viewModels()
    private val args: MarketPlaceDetailFragmentArgs by navArgs()

    private val imageListAdapter by lazy { ImageListAdapter() }
    private val attributeListAdapter by lazy { AttributeListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketplaceDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        setUpView()
    }

    private fun setUpView() {
        binding?.apply {
            // set adapters and error view
            imageRecyclerView.apply {
                adapter = imageListAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
            attributesRecyclerView.apply {
                adapter = attributeListAdapter
                layoutManager = LinearLayoutManager(context)
            }

            includeContentErrorLoadingView.apply {
                btnRetry.setOnClickListener {
                    viewModel.getMarketDetailEvent(args.marketPlaceIdentifier)
                }
            }
        }
        viewModel.getMarketDetailEvent(args.marketPlaceIdentifier)
    }

    private fun initObservers() {
        viewModel.marketPlaceDetailLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Error -> showErrorView()
                is Resource.Loading -> showLoadingView()
                is Resource.Success -> showSuccessView(result.data)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.marketPlaceDetailEvent.collect { event ->
                when (event) {
                    is MarketPlaceDetailEvent.GetMarketDetail -> {
                        viewModel.getMarketPlaceDetail(event.marketPlaceIdentifier)
                    }
                }
            }
        }
    }

    private fun showSuccessView(data: MarketPlaceDetailViewData?) {
        if (data != null) {
            binding?.apply {
                groupContent.visible()
                includeContentErrorLoadingView.root.gone()
                // fill out adapters / controls
                imageListAdapter.submitList(data.pictures)
                attributeListAdapter.submitList(data.attributes)
                tvCondition.text = data.condition
                tvTitle.text = data.title
                tvPrice.text =
                    String.format(getString(R.string.format_locale_item_price, data.price))
            }
        } else {
            showErrorView()
        }
    }

    private fun showLoadingView() {
        binding?.apply {
            groupContent.gone()
            includeContentErrorLoadingView.apply {
                root.visible()
                progressBar.visible()
                llErrorRetry.gone()
            }
        }
    }

    private fun showErrorView() {
        binding?.apply {
            groupContent.gone()
            includeContentErrorLoadingView.apply {
                root.visible()
                progressBar.gone()
                llErrorRetry.visible()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}