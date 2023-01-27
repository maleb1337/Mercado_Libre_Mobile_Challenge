package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.maleb.mercadolibre.mobile.challenge.databinding.ItemAttributeDetailBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.AttributeViewData

class AttributeListAdapter :
    ListAdapter<AttributeViewData, AttributeListAdapter.AttributeViewHolder>(AttributesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        val binding =
            ItemAttributeDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AttributeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class AttributeViewHolder(private val binding: ItemAttributeDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AttributeViewData) {
            binding.apply {
                textViewTitle.text = item.name
                textViewDescription.text = item.valueName
            }
        }
    }

    class AttributesComparator : DiffUtil.ItemCallback<AttributeViewData>() {
        override fun areItemsTheSame(oldItem: AttributeViewData, newItem: AttributeViewData) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: AttributeViewData,
            newItem: AttributeViewData
        ) = oldItem == newItem

    }

}