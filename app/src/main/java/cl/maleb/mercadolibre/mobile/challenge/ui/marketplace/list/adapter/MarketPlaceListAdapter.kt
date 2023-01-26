package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import cl.maleb.mercadolibre.mobile.challenge.databinding.ItemMarketplaceBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData

class MarketPlaceListAdapter :
    PagingDataAdapter<MarketPlaceListItemViewData, MarketPlaceListViewHolder>(LIST_COMPARATOR) {

    var onItemClickListener: ((item: MarketPlaceListItemViewData) -> Unit)? = null

    companion object {
        private val LIST_COMPARATOR =
            object : DiffUtil.ItemCallback<MarketPlaceListItemViewData>() {
                override fun areItemsTheSame(
                    oldItem: MarketPlaceListItemViewData,
                    newItem: MarketPlaceListItemViewData
                ): Boolean = oldItem.marketPlaceIdentifier == newItem.marketPlaceIdentifier

                override fun areContentsTheSame(
                    oldItem: MarketPlaceListItemViewData,
                    newItem: MarketPlaceListItemViewData
                ): Boolean = oldItem == newItem
            }
    }

    override fun onBindViewHolder(holder: MarketPlaceListViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketPlaceListViewHolder {
        val binding = ItemMarketplaceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MarketPlaceListViewHolder(binding, onItemClickListener)
    }
}