package com.jay.wj_clean_architecture.utils.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_clean_architecture.model.WJViewModel
import com.jay.wj_clean_architecture.ui.home.HomeAdapter

@BindingAdapter("movieSubmitList")
fun RecyclerView.bindSubmitList(item: List<WJViewModel>?) {
    with((adapter as HomeAdapter)) {
        this.clear()
        item?.let { this.addItems(it) }
    }
}