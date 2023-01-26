package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.adapter

import androidx.recyclerview.widget.RecyclerView
import cl.maleb.mercadolibre.mobile.challenge.R
import cl.maleb.mercadolibre.mobile.challenge.databinding.ItemMarketplaceBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.list.model.MarketPlaceListItemViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.loadGlideImage

class MarketPlaceListViewHolder(
    private val binding: ItemMarketplaceBinding,
    private val onItemClickListener: ((item: MarketPlaceListItemViewData) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MarketPlaceListItemViewData) {
        val context = binding.root.context
        binding.apply {
            ivList.loadGlideImage(item.imageUrl)
            tvBrandTitle.text = item.brandName
            tvProductName.text = item.productName
            tvProductPrice.text = String.format(
                context.getString(R.string.format_locale_item_price), item.price
            )
            root.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
        }
    }
}