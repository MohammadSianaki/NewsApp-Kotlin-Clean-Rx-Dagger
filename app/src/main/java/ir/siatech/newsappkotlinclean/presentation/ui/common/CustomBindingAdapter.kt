package ir.siatech.newsappkotlinclean.presentation.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object CustomBindingAdapter {
    @JvmStatic
    @BindingAdapter("app:image_url")
    fun loadImage(imageView: AppCompatImageView, url: String) {
        Glide.with(imageView).load(url).into(imageView)
    }
}