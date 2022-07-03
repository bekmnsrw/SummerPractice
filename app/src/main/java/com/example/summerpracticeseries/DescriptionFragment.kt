package com.example.summerpracticeseries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.summerpracticeseries.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val series: Series = SeriesRepository.series.single {
            it.id == arguments?.getInt(ARG_ID)
        }

        Glide.with(this).load(series.url).into(binding.ivCover)
        binding.tvName.text = "Name: " + series.name
        binding.tvGenre.text = "Genre: " + series.genre
        binding.tvYear.text = "Year: " + series.year
        binding.tvDescription.text = "Description: "+ series.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_ID = "ARG_ID"

        fun createBundle(id: Int) = Bundle().apply {
            putInt(ARG_ID, id)
        }
    }
}