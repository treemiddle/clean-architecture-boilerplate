package com.jay.wj_clean_architecture.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jay.wj_clean_architecture.databinding.ItemHomeBinding
import com.jay.wj_clean_architecture.model.WJViewModel

typealias RecyclerViewOnItemClick = (WJViewModel) -> Unit

class HomeAdapter(
    private val onItemClick: RecyclerViewOnItemClick? = null
) : RecyclerView.Adapter<HomeAdapter.HomeItemHolder>() {

    private val movies = mutableListOf<WJViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemHolder {
        return HomeItemHolder.create(parent).also {
            if (onItemClick == null) {
                return@also
            } else {
                it.itemView.setOnClickListener { _ ->
                    val currentItem = movies.getOrNull(it.adapterPosition) ?: return@setOnClickListener
                    onItemClick.invoke(currentItem)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: HomeItemHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    /**
     * imageview clear logic
     */
    override fun onViewRecycled(holder: HomeItemHolder) {
        super.onViewRecycled(holder)
    }

    class HomeItemHolder(
        private val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WJViewModel) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object Factory {
            fun create(parent: ViewGroup): HomeItemHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemHomeBinding.inflate(inflater, parent, false)

                return HomeItemHolder(view)
            }
        }

    }

    fun addItems(items: List<WJViewModel>) {
        this.movies.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        this.movies.clear()
    }
}