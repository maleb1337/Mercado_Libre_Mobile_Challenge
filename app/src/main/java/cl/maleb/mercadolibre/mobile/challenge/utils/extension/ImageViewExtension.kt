package cl.maleb.mercadolibre.mobile.challenge.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadGlideImage(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}