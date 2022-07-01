package com.example.summerpractice2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice2.databinding.FragmentNewsBinding

class NewsFragment : Fragment(R.layout.fragment_news) {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentNewsBinding.bind(view)

        binding.btnMain.setOnClickListener {
            val currentFragment = view.findFragment<Fragment>().toString().substringBefore("{")
            findNavController().navigate(R.id.action_newsFragment_to_mainFragment, MainFragment.createBundle(currentFragment))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}