package com.example.summerpracticeseries

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpracticeseries.databinding.FragmentSeriesBinding

class SeriesFragment : Fragment(R.layout.fragment_series) {

    private var _binding: FragmentSeriesBinding? = null
    private val binding get() = _binding!!

    private var adapter: SeriesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSeriesBinding.bind(view)

        adapter = SeriesAdapter(SeriesRepository.series, Glide.with(this)) { id ->
            findNavController().navigate(
                R.id.action_seriesFragment_to_descriptionFragment,
                DescriptionFragment.createBundle(id)
            )
        }

        binding.rvSeries.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}