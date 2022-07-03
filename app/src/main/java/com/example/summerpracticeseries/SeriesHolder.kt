package com.example.summerpracticeseries

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpracticeseries.databinding.ItemSeriesBinding

class SeriesHolder(
    private val binding: ItemSeriesBinding,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun onBind(series: Series) {
        with(binding) {
            tvName.text = series.name
            tvGenre.text = series.genre

            glide.load(series.url).into(ivCover)

            root.setOnClickListener {
                onItemClick(series.id)
            }
        }
    }
}