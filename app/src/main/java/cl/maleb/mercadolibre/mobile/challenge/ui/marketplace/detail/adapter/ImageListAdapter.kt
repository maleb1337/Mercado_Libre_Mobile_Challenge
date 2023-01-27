package cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.maleb.mercadolibre.mobile.challenge.databinding.ItemImageDetailBinding
import cl.maleb.mercadolibre.mobile.challenge.ui.marketplace.detail.model.PictureViewData
import cl.maleb.mercadolibre.mobile.challenge.utils.extension.loadGlideImage

class ImageListAdapter :
    ListAdapter<PictureViewData, ImageListAdapter.ImageViewHolder>(ImageComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ItemImageDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class ImageViewHolder(private val binding: ItemImageDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PictureViewData) {
            binding.apply {
                imageView.loadGlideImage(item.imageUrl)
            }
        }
    }

    class ImageComparator : DiffUtil.ItemCallback<PictureViewData>() {
        override fun areItemsTheSame(oldItem: PictureViewData, newItem: PictureViewData) =
            oldItem.imageUrl == newItem.imageUrl

        override fun areContentsTheSame(oldItem: PictureViewData, newItem: PictureViewData) =
            oldItem == newItem


    }

}
