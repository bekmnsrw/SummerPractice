package com.example.summerpracticeseries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpracticeseries.databinding.ItemSeriesBinding

class SeriesAdapter(
    private val list: List<Series>,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<SeriesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesHolder = SeriesHolder(
        ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        glide,
        onItemClick
    )

    override fun onBindViewHolder(holder: SeriesHolder, position: Int) = holder.onBind(list[position])

    override fun getItemCount(): Int = list.size
}