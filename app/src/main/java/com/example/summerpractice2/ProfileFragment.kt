package com.example.summerpractice2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice2.databinding.FragmentMusicBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMusicBinding.bind(view)

        binding.btnMain.setOnClickListener {
            val currentFragment = view.findFragment<Fragment>().toString().substringBefore("{")
            findNavController().navigate(R.id.action_profileFragment_to_mainFragment, MainFragment.createBundle(currentFragment))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}