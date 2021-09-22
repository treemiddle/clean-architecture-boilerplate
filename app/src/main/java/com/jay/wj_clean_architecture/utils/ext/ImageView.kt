package com.jay.wj_clean_architecture.utils.ext

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(
    value = [
        "imgSrc",
        "imgPlaceholder",
        "imgError"
    ], requireAll = false
)
fun ImageView.bindImage(src: String?, placeholder: Drawable?, error: Drawable?) {
    src ?: return

    Glide.with(this)
        .load(src)
        .error(error)
        .placeholder(placeholder)
        .into(this)
}